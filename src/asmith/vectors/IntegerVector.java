//	Copyright 2017 Adam Smith
//
//	Licensed under the Apache License, Version 2.0 (the "License");
//	you may not use this file except in compliance with the License.
//	You may obtain a copy of the License at
//
//	http://www.apache.org/licenses/LICENSE-2.0
//
//	Unless required by applicable law or agreed to in writing, software
//	distributed under the License is distributed on an "AS IS" BASIS,
//	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//	See the License for the specific language governing permissions and
//	limitations under the License.

package asmith.vectors;

public final class IntegerVector extends VectorCommon<Integer> {
	private final int[] mElements;
	
	public IntegerVector(int[] aValue) {
		mElements = aValue;
	}
	
	public IntegerVector(Integer[] aValue) {
		final int s = aValue.length;
		mElements = new int[s];
		for(int i = 0; i < s; ++i) mElements[i] = aValue[i];
	}
	
	public IntegerVector(int aX, int aY) {
		mElements = new int[] { aX, aY };
	}
	
	public IntegerVector(int aX, int aY, int aZ) {
		mElements = new int[] { aX, aY, aZ };
	}
	
	public IntegerVector(int aX, int aY, int aZ, int aW) {
		mElements = new int[] { aX, aY, aZ, aW };
	}	
	
	public IntegerVector(int aX, Vector<Integer> aV1) {
		final int s = aV1.size();
		mElements = new int[s+1];
		mElements[0] = aX;
		for(int i = 0; i < s; ++i) mElements[i+1] = aV1.get(i);
	}
	
	public IntegerVector(Vector<Integer> aV1, int aY) {
		final int s = aV1.size();
		mElements = new int[s+1];
		for(int i = 0; i < s; ++i) mElements[i] = aV1.get(i);
		mElements[s] = aY;
	}
	
	public IntegerVector(int aX, Vector<Integer> aV1, int aY) {
		final int s = aV1.size();
		mElements = new int[s+2];
		mElements[0] = aX;
		for(int i = 0; i < s; ++i) mElements[i+1] = aV1.get(i);
		mElements[s+1] = aY;
	}
	
	public IntegerVector(Vector<Integer> aV1, Vector<Integer> aV2) {
		final int s1 = aV1.size();
		final int s2 = aV2.size();
		mElements = new int[s1+s2];
		for(int i = 0; i < s1; ++i) mElements[i] = aV1.get(i);
		for(int i = 0; i < s2; ++i) mElements[i + s1] = aV2.get(i);
	}
	
	public IntegerVector(Vector<? extends Number> aOther) {
		final int s = aOther.size();
		mElements = new int[s];
		for(int i = 0; i < s; ++i) mElements[i] = aOther.get(i).intValue();
	}
	
	// Inherited from VectorCommon

	@Override
	protected Integer sqrt(Integer aValue) {
		return (int) Math.sqrt(aValue);
	}

	@Override
	protected Integer add(Integer aA, Integer aB) {
		return aA + aB;
	}

	@Override
	protected Integer sub(Integer aA, Integer aB) {
		return aA - aB;
	}

	@Override
	protected Integer mul(Integer aA, Integer aB) {
		return aA * aB;
	}

	@Override
	protected Integer div(Integer aA, Integer aB) {
		return aA / aB;
	}

	@Override
	protected Integer valueOf(int aValue) {
		return Integer.valueOf(aValue);
	}

	@Override
	protected Integer min(Integer aA, Integer aB) {
		return Math.min(aA, aB);
	}

	@Override
	protected Integer max(Integer aA, Integer aB) {
		return Math.max(aA, aB);
	}

	@Override
	protected VectorCommon<Integer> createVector(Integer[] aValues) {
		return new IntegerVector(aValues);
	}

	@Override
	protected Integer[] createArray(int aSize) {
		return new Integer[aSize];
	}
	
	// Inherited from Vector

	@Override
	public int size() {
		return mElements.length;
	}

	@Override
	public Vector<Integer> set(int aIndex, Integer aValue) {
		final int s = mElements.length;
		final int[] tmp = new int[s];
		for(int i = 0; i < s; ++i) tmp[i] = mElements[i];
		tmp[aIndex] = aValue;
		return new IntegerVector(tmp);
	}

	@Override
	public Integer get(int aIndex) {
		return mElements[aIndex];
	}

}
