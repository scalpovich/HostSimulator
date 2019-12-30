/*--------------------------------------------------------------------------------------------
 * This file is used for maintaining the length of Bitfields per ISO 8583
 * All the positive numbers denote the exact length of the bitfield
 * Negative numbers denote that the bitfield has a variable length
 * -2 denotes that the first two bytes represents the length
 * -3 denotes that the first three bytes represents the length
 * -------------------------------------------------------------------------------------------
 */
package com.HostSimulator;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class BitFieldData {

	public Map<String, Integer> bitfieldLength = new HashMap<String, Integer>();

	public BitFieldData() {
		bitfieldLength.put("BITFIELD1", 8);
		bitfieldLength.put("BITFIELD2", -2);
		bitfieldLength.put("BITFIELD3", 6);
		bitfieldLength.put("BITFIELD4", 12);
		bitfieldLength.put("BITFIELD5", 0);
		bitfieldLength.put("BITFIELD6", 0);
		bitfieldLength.put("BITFIELD7", 10);
		bitfieldLength.put("BITFIELD8", 0);
		bitfieldLength.put("BITFIELD9", 0);
		bitfieldLength.put("BITFIELD10", 0);
		bitfieldLength.put("BITFIELD11", 6);
		bitfieldLength.put("BITFIELD12", 12);
		bitfieldLength.put("BITFIELD13", 0);
		bitfieldLength.put("BITFIELD14", 4);
		bitfieldLength.put("BITFIELD15", 6);
		bitfieldLength.put("BITFIELD16", 0);
		bitfieldLength.put("BITFIELD17", 4);
		bitfieldLength.put("BITFIELD18", 4);
		bitfieldLength.put("BITFIELD19", 3);
		bitfieldLength.put("BITFIELD20", 0);
		bitfieldLength.put("BITFIELD21", 0);
		bitfieldLength.put("BITFIELD22", 12);
		bitfieldLength.put("BITFIELD23", 3);
		bitfieldLength.put("BITFIELD24", 3);
		bitfieldLength.put("BITFIELD25", 4);
		bitfieldLength.put("BITFIELD26", 0);
		bitfieldLength.put("BITFIELD27", 0);
		bitfieldLength.put("BITFIELD28", 6);
		bitfieldLength.put("BITFIELD29", 0);
		bitfieldLength.put("BITFIELD30", 24);
		bitfieldLength.put("BITFIELD31", 0);
		bitfieldLength.put("BITFIELD32", -2);
		bitfieldLength.put("BITFIELD33", 0);
		bitfieldLength.put("BITFIELD34", -2);
		bitfieldLength.put("BITFIELD35", -2);
		bitfieldLength.put("BITFIELD36", 0);
		bitfieldLength.put("BITFIELD37", 12);
		bitfieldLength.put("BITFIELD38", 6);
		bitfieldLength.put("BITFIELD39", 3);
		bitfieldLength.put("BITFIELD40", 0);
		bitfieldLength.put("BITFIELD41", 8);
		bitfieldLength.put("BITFIELD42", 15);
		bitfieldLength.put("BITFIELD43", -2);
		bitfieldLength.put("BITFIELD44", -2);
		bitfieldLength.put("BITFIELD45", -2);
		bitfieldLength.put("BITFIELD46", -3);
		bitfieldLength.put("BITFIELD47", 0);
		bitfieldLength.put("BITFIELD48", -3);
		bitfieldLength.put("BITFIELD49", 3);
		bitfieldLength.put("BITFIELD50", 3);
		bitfieldLength.put("BITFIELD51", 0);
		bitfieldLength.put("BITFIELD52", 8);
		bitfieldLength.put("BITFIELD53", -2);
		bitfieldLength.put("BITFIELD54", -3);
		bitfieldLength.put("BITFIELD55", -3);
		bitfieldLength.put("BITFIELD56", -2);
		bitfieldLength.put("BITFIELD57", 0);
		bitfieldLength.put("BITFIELD58", -2);
		bitfieldLength.put("BITFIELD59", -3);
		bitfieldLength.put("BITFIELD60", 0);
		bitfieldLength.put("BITFIELD61", 0);
		bitfieldLength.put("BITFIELD62", -3);
		bitfieldLength.put("BITFIELD63", -3);
		bitfieldLength.put("BITFIELD64", 0);
		bitfieldLength.put("BITFIELD65", 0);
		bitfieldLength.put("BITFIELD66", 0);
		bitfieldLength.put("BITFIELD67", 0);
		bitfieldLength.put("BITFIELD68", 0);
		bitfieldLength.put("BITFIELD69", 0);
		bitfieldLength.put("BITFIELD70", 0);
		bitfieldLength.put("BITFIELD71", 0);
		bitfieldLength.put("BITFIELD72", -3);
		bitfieldLength.put("BITFIELD73", 6);
		bitfieldLength.put("BITFIELD74", 0);
		bitfieldLength.put("BITFIELD75", 0);
		bitfieldLength.put("BITFIELD76", 0);
		bitfieldLength.put("BITFIELD77", 0);
		bitfieldLength.put("BITFIELD78", 0);
		bitfieldLength.put("BITFIELD79", 0);
		bitfieldLength.put("BITFIELD80", 0);
		bitfieldLength.put("BITFIELD81", 0);
		bitfieldLength.put("BITFIELD82", 0);
		bitfieldLength.put("BITFIELD83", 0);
		bitfieldLength.put("BITFIELD84", 0);
		bitfieldLength.put("BITFIELD85", 0);
		bitfieldLength.put("BITFIELD86", 0);
		bitfieldLength.put("BITFIELD87", 0);
		bitfieldLength.put("BITFIELD88", 0);
		bitfieldLength.put("BITFIELD89", 0);
		bitfieldLength.put("BITFIELD90", 0);
		bitfieldLength.put("BITFIELD91", 0);
		bitfieldLength.put("BITFIELD92", 0);
		bitfieldLength.put("BITFIELD93", 0);
		bitfieldLength.put("BITFIELD94", 0);
		bitfieldLength.put("BITFIELD95", 0);
		bitfieldLength.put("BITFIELD96", -3);
		bitfieldLength.put("BITFIELD97", 16);
		bitfieldLength.put("BITFIELD98", 0);
		bitfieldLength.put("BITFIELD99", 0);
		bitfieldLength.put("BITFIELD100", 0);
		bitfieldLength.put("BITFIELD101", 0);
		bitfieldLength.put("BITFIELD102", -2);
		bitfieldLength.put("BITFIELD103", -2);
		bitfieldLength.put("BITFIELD104", 0);
		bitfieldLength.put("BITFIELD105", 0);
		bitfieldLength.put("BITFIELD106", 0);
		bitfieldLength.put("BITFIELD107", 0);
		bitfieldLength.put("BITFIELD108", 0);
		bitfieldLength.put("BITFIELD109", 0);
		bitfieldLength.put("BITFIELD110", 0);
		bitfieldLength.put("BITFIELD111", 0);
		bitfieldLength.put("BITFIELD112", 0);
		bitfieldLength.put("BITFIELD113", 0);
		bitfieldLength.put("BITFIELD114", 0);
		bitfieldLength.put("BITFIELD115", -3);
		bitfieldLength.put("BITFIELD116", -3);
		bitfieldLength.put("BITFIELD117", -3);
		bitfieldLength.put("BITFIELD118", 0);
		bitfieldLength.put("BITFIELD119", 0);
		bitfieldLength.put("BITFIELD120", 0);
		bitfieldLength.put("BITFIELD121", 0);
		bitfieldLength.put("BITFIELD122", 0);
		bitfieldLength.put("BITFIELD123", -3);
		bitfieldLength.put("BITFIELD124", -3);
		bitfieldLength.put("BITFIELD125", -3);
		bitfieldLength.put("BITFIELD126", -3);
		bitfieldLength.put("BITFIELD127", -3);
		bitfieldLength.put("BITFIELD128", 0);
	}
}