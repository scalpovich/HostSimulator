package com.HostSimulator;

import java.util.LinkedHashMap;
import java.util.Map;

import com.HostSimulator.BitFieldData;

public class HexDecoder {

	public static Converter converter = new Converter();
	private int dataLength, currentPosition;
	private String eHeader, MTI, primaryBitMap, secondaryBitmap, consolidatedBitmap;
	Map<String, String> bitFieldwithValues = new LinkedHashMap<String, String>();

	public HexDecoder(String hexData) {
		try {
			decodedData(hexData);
		} catch (NumberFormatException e) {
			System.out.println("Request packet Format error. Please make sure the Hex data is correct");
		}

	}

	public int getDataLength() {
		return dataLength;
	}

	public String geteHeader() {
		return eHeader;
	}

	public String getMTI() {
		return MTI;
	}

	public String getPrimaryBitMap() {
		return primaryBitMap;
	}

	public String getSecondaryBitmap() {
		return secondaryBitmap;
	}

	public String getConsolidatedBitmap() {
		return consolidatedBitmap;
	}

	public Map<String, String> getBitFieldwithValues() {
		return bitFieldwithValues;
	}

	// -----------------------------------------------------------------------------------------------------------
	/*
	 * Takes the hex array as input, splits the data and convets into ascii
	 * values
	 */
	// -----------------------------------------------------------------------------------------------------------
	public void decodedData(String hexData) {
		hexData = converter.addSpacesToString(hexData);
		Boolean isSecondaryBitmapAvailable = false;
		String hexDataLengthValue, primaryBitmapValue, secondaryBitmapValue;

		// Grep the data length from hexData
		// hexDataLengthValue = hexData.substring(0, 5);
		// String dataLengthInDecimal =
		// converter.hexToDecimal(hexDataLengthValue);
		// dataLengthInDecimal = dataLengthInDecimal.replaceAll("\\s", "");
		// dataLength = Integer.parseInt(dataLengthInDecimal);

		// Grep the eHeader from hexData
		// eHeader = converter.hexToASCII(hexData.substring(6, 95));
		eHeader = converter.hexToASCII(hexData.substring(0, 89));

		// Echo requests would have only the eheader. Hence the condition to
		// check data length
		// if (dataLength > 95) {
		if (hexData.length() > 89) {
			// Grep the MTI from hexData
			// MTI = converter.hexToASCII(hexData.substring(96, 107));
			MTI = converter.hexToASCII(hexData.substring(90, 101));

			// Grep the primary bitmap from hexData
			// primaryBitmapValue = hexData.substring(108, 131);
			primaryBitmapValue = hexData.substring(102, 125);
			primaryBitMap = converter.hexToBinary(primaryBitmapValue);
			// currentPosition = 88;
			currentPosition = 84;
			if (primaryBitMap.charAt(0) == '1') {
				isSecondaryBitmapAvailable = true;
			}

			// Grep the secondary bitmap from hex Data if available
			if (isSecondaryBitmapAvailable) {
				// secondaryBitmapValue = hexData.substring(132, 155);
				secondaryBitmapValue = hexData.substring(126, 149);
				secondaryBitmap = converter.hexToBinary(secondaryBitmapValue);
				// currentPosition = 104;
				currentPosition = 100;
			}

			// Bitmap consolidation
			if (isSecondaryBitmapAvailable) {
				consolidatedBitmap = primaryBitMap.replaceAll("\\s", "") + secondaryBitmap.replaceAll("\\s", "");
			} else {
				consolidatedBitmap = primaryBitMap.replaceAll("\\s", "");
			}

			// identify the bitfields involved in the transaction
			bitFieldwithValues = bitfieldAndValueMapping(consolidatedBitmap, hexData);
		}
		// printEncodedData(hexData.length());
	}

	// --------------------------------------------------------------------------------------------------
	/*
	 * This function is used to identify the bitfields involved in the
	 * transaction Takes the consolidated bitmap as input and returns a string
	 * with integers representing bitfields
	 */
	// ---------------------------------------------------------------------------------------------------
	public String getElementsInTransaction(String bitmap) {
		String elementsInTransaction = "";
		for (int i = 0; i < bitmap.length(); i++) {
			if (bitmap.charAt(i) == '1') {
				elementsInTransaction = elementsInTransaction + (i + 1) + " ";
			}
		}
		return elementsInTransaction;
	}

	// -----------------------------------------------------------------------------------------------------
	/*
	 * This function is used to process the bitmap and identify the values
	 * associated with bitfields Takes consolidated bitmap involved in the
	 * transaction as input. Returns a linked hashmap which has bitfields as key
	 * and corresponding values as hashmap value
	 */
	// ------------------------------------------------------------------------------------------------------
	public Map<String, String> bitfieldAndValueMapping(String consolidatedBitmap, String hexData) {
		Map<String, String> bitfieldAndValueMap = new LinkedHashMap<String, String>();
		String tempString = getElementsInTransaction(consolidatedBitmap);
		String tempHexData = hexData.replaceAll("\\s", "");
		BitFieldData bitfieldLength = new BitFieldData(true);
		String[] elements = tempString.split(" ");
		for (String element : elements) {
			String currentBitField = "BITFIELD" + element, currentBitFieldValue;
			int currentBitfieldLength = (bitfieldLength.bitfieldLength.get(currentBitField)) * 2;
			if (currentBitfieldLength > 0 && (currentBitField.equals("BITFIELD1")) == false) {
				currentBitFieldValue = tempHexData.substring(currentPosition, currentPosition + currentBitfieldLength);
				currentBitFieldValue = converter.hexToASCII(converter.addSpacesToString(currentBitFieldValue));
				bitfieldAndValueMap.put(currentBitField, currentBitFieldValue);
				currentPosition = currentPosition + currentBitfieldLength;
			} else if (currentBitfieldLength == -4) {
				currentBitfieldLength = Integer.parseInt(converter.hexToASCII(
						converter.addSpacesToString(tempHexData.substring(currentPosition, currentPosition + 4))));
				currentPosition = currentPosition + 4;
				currentBitfieldLength = (currentBitfieldLength) * 2;
				currentBitFieldValue = tempHexData.substring(currentPosition, currentPosition + currentBitfieldLength);
				tempString = (Integer.toString(currentBitfieldLength / 2));
				if (tempString.length() < 2) {
					tempString = "0" + tempString;
				}
				currentBitFieldValue = tempString
						+ converter.hexToASCII(converter.addSpacesToString(currentBitFieldValue));
				bitfieldAndValueMap.put(currentBitField, currentBitFieldValue);
				currentPosition = currentPosition + currentBitfieldLength;
			} else if (currentBitfieldLength == -6) {

				currentBitfieldLength = Integer.parseInt(converter.hexToASCII(
						converter.addSpacesToString(tempHexData.substring(currentPosition, currentPosition + 6))));
				currentPosition = currentPosition + 6;
				currentBitfieldLength = (currentBitfieldLength) * 2;
				currentBitFieldValue = tempHexData.substring(currentPosition, currentPosition + currentBitfieldLength);
				tempString = (Integer.toString(currentBitfieldLength / 2));
				if (tempString.length() < 3) {
					if (tempString.length() < 2) {
						tempString = "00" + tempString;
					} else {
						tempString = "0" + tempString;
					}
				}
				currentBitFieldValue = tempString
						+ converter.hexToASCII(converter.addSpacesToString(currentBitFieldValue));
				bitfieldAndValueMap.put(currentBitField, currentBitFieldValue);
				currentPosition = currentPosition + currentBitfieldLength;
			}

		}
		return bitfieldAndValueMap;
	}

	// -----------------------------------------------------------------------------------------------------------------------------------------
	/*
	 * This function is used to retrive all the available data involved in the
	 * transaction
	 */
	// -----------------------------------------------------------------------------------------------------------------------------------------
	public void printEncodedData() {
		System.out.println("------------------------------------");
		try {
			System.out.println("eHeader: " + eHeader);
			System.out.println("MTI: " + MTI);
			for (Map.Entry<String, String> currentEntry : bitFieldwithValues.entrySet()) {
				System.out.println(currentEntry.getKey() + ": " + currentEntry.getValue());
			}
		System.out.println("------------------------------------");	
		} catch (NullPointerException e) {
			System.out.println("Few data unavailable");
		}

	}
}