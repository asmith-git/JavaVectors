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

public final class ByteVector extends VectorCommon<Byte> {
	private final byte[] mElements;
	
	public ByteVector(byte[] aValue) {
		mElements = aValue;
	}
	
	public ByteVector(Byte[] aValue) {
		final int s = aValue.length;
		mElements = new byte[s];
		for(int i = 0; i < s; ++i) mElements[i] = aValue[i];
	}
	
	public ByteVector(byte aX, byte aY) {
		mElements = new byte[] { aX, aY };
	}
	
	public ByteVector(byte aX, byte aY, byte aZ) {
		mElements = new byte[] { aX, aY, aZ };
	}
	
	public ByteVector(byte aX, byte aY, byte aZ, byte aW) {
		mElements = new byte[] { aX, aY, aZ, aW };
	}	
	
	public ByteVector(byte aX, Vector<Byte> aV1) {
		final int s = aV1.size();
		mElements = new byte[s+1];
		mElements[0] = aX;
		for(int i = 0; i < s; ++i) mElements[i+1] = aV1.get(i);
	}
	
	public ByteVector(Vector<Byte> aV1, byte aY) {
		final int s = aV1.size();
		mElements = new byte[s+1];
		for(int i = 0; i < s; ++i) mElements[i] = aV1.get(i);
		mElements[s] = aY;
	}
	
	public ByteVector(byte aX, Vector<Byte> aV1, byte aY) {
		final int s = aV1.size();
		mElements = new byte[s+2];
		mElements[0] = aX;
		for(int i = 0; i < s; ++i) mElements[i+1] = aV1.get(i);
		mElements[s+1] = aY;
	}
	
	public ByteVector(Vector<Byte> aV1, Vector<Byte> aV2) {
		final int s1 = aV1.size();
		final int s2 = aV2.size();
		mElements = new byte[s1+s2];
		for(int i = 0; i < s1; ++i) mElements[i] = aV1.get(i);
		for(int i = 0; i < s2; ++i) mElements[i + s1] = aV2.get(i);
	}
	
	public ByteVector(Vector<? extends Number> aOther) {
		final int s = aOther.size();
		mElements = new byte[s];
		for(int i = 0; i < s; ++i) mElements[i] = aOther.get(i).byteValue();
	}
	
	// Inherited from VectorCommon

	@Override
	protected Byte sqrt(Byte aValue) {
		return (byte) Math.sqrt(aValue);
	}

	@Override
	protected Byte add(Byte aA, Byte aB) {
		return (byte) (aA + aB);
	}

	@Override
	protected Byte sub(Byte aA, Byte aB) {
		return (byte) (aA - aB);
	}

	@Override
	protected Byte mul(Byte aA, Byte aB) {
		return (byte) (aA * aB);
	}

	@Override
	protected Byte div(Byte aA, Byte aB) {
		return (byte) (aA / aB);
	}

	@Override
	protected Byte valueOf(int aValue) {
		return (byte) aValue;
	}

	@Override
	protected Byte min(Byte aA, Byte aB) {
		return (byte) Math.min(aA, aB);
	}

	@Override
	protected Byte max(Byte aA, Byte aB) {
		return (byte) Math.max(aA, aB);
	}

	@Override
	protected VectorCommon<Byte> createVector(Byte[] aValues) {
		return new ByteVector(aValues);
	}

	@Override
	protected Byte[] createArray(int aSize) {
		return new Byte[aSize];
	}
	
	// Inherited from Vector

	@Override
	public int size() {
		return mElements.length;
	}

	@Override
	public Vector<Byte> set(int aIndex, Byte aValue) {
		final int s = mElements.length;
		final byte[] tmp = new byte[s];
		for(int i = 0; i < s; ++i) tmp[i] = mElements[i];
		tmp[aIndex] = aValue;
		return new ByteVector(tmp);
	}

	@Override
	public Byte get(int aIndex) {
		return mElements[aIndex];
	}

}
