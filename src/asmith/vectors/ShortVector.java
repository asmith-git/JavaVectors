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

public final class ShortVector extends VectorCommon<Short> {
	private final short[] mElements;
	
	public ShortVector(short[] aValue) {
		mElements = aValue;
	}
	
	public ShortVector(Short[] aValue) {
		final int s = aValue.length;
		mElements = new short[s];
		for(int i = 0; i < s; ++i) mElements[i] = aValue[i];
	}
	
	public ShortVector(short aX, short aY) {
		mElements = new short[] { aX, aY };
	}
	
	public ShortVector(short aX, short aY, short aZ) {
		mElements = new short[] { aX, aY, aZ };
	}
	
	public ShortVector(short aX, short aY, short aZ, short aW) {
		mElements = new short[] { aX, aY, aZ, aW };
	}	
	
	public ShortVector(short aX, Vector<Short> aV1) {
		final int s = aV1.size();
		mElements = new short[s+1];
		mElements[0] = aX;
		for(int i = 0; i < s; ++i) mElements[i+1] = aV1.get(i);
	}
	
	public ShortVector(Vector<Short> aV1, short aY) {
		final int s = aV1.size();
		mElements = new short[s+1];
		for(int i = 0; i < s; ++i) mElements[i] = aV1.get(i);
		mElements[s] = aY;
	}
	
	public ShortVector(short aX, Vector<Short> aV1, short aY) {
		final int s = aV1.size();
		mElements = new short[s+2];
		mElements[0] = aX;
		for(int i = 0; i < s; ++i) mElements[i+1] = aV1.get(i);
		mElements[s+1] = aY;
	}
	
	public ShortVector(Vector<Short> aV1, Vector<Short> aV2) {
		final int s1 = aV1.size();
		final int s2 = aV2.size();
		mElements = new short[s1+s2];
		for(int i = 0; i < s1; ++i) mElements[i] = aV1.get(i);
		for(int i = 0; i < s2; ++i) mElements[i + s1] = aV2.get(i);
	}
	
	public ShortVector(Vector<? extends Number> aOther) {
		final int s = aOther.size();
		mElements = new short[s];
		for(int i = 0; i < s; ++i) mElements[i] = aOther.get(i).shortValue();
	}
	
	// Inherited from VectorCommon

	@Override
	protected Short sqrt(Short aValue) {
		return (short) Math.sqrt(aValue);
	}

	@Override
	protected Short add(Short aA, Short aB) {
		return (short) (aA + aB);
	}

	@Override
	protected Short sub(Short aA, Short aB) {
		return (short) (aA - aB);
	}

	@Override
	protected Short mul(Short aA, Short aB) {
		return (short) (aA * aB);
	}

	@Override
	protected Short div(Short aA, Short aB) {
		return (short) (aA / aB);
	}

	@Override
	protected Short valueOf(int aValue) {
		return (short) aValue;
	}

	@Override
	protected Short min(Short aA, Short aB) {
		return (short) Math.min(aA, aB);
	}

	@Override
	protected Short max(Short aA, Short aB) {
		return (short) Math.max(aA, aB);
	}

	@Override
	protected VectorCommon<Short> createVector(Short[] aValues) {
		return new ShortVector(aValues);
	}

	@Override
	protected Short[] createArray(int aSize) {
		return new Short[aSize];
	}
	
	// Inherited from Vector

	@Override
	public int size() {
		return mElements.length;
	}

	@Override
	public Vector<Short> set(int aIndex, Short aValue) {
		final int s = mElements.length;
		final short[] tmp = new short[s];
		for(int i = 0; i < s; ++i) tmp[i] = mElements[i];
		tmp[aIndex] = aValue;
		return new ShortVector(tmp);
	}

	@Override
	public Short get(int aIndex) {
		return mElements[aIndex];
	}

}
