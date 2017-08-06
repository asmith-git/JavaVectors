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

import java.math.BigInteger;

public final class BigIntegerVector extends VectorCommon<BigInteger> {
	private final BigInteger[] mElements;
	
	public BigIntegerVector(BigInteger[] aValue) {
		mElements = aValue;
	}
	
	public BigIntegerVector(BigInteger aX, BigInteger aY) {
		mElements = new BigInteger[] { aX, aY };
	}
	
	public BigIntegerVector(BigInteger aX, BigInteger aY, BigInteger aZ) {
		mElements = new BigInteger[] { aX, aY, aZ };
	}
	
	public BigIntegerVector(BigInteger aX, BigInteger aY, BigInteger aZ, BigInteger aW) {
		mElements = new BigInteger[] { aX, aY, aZ, aW };
	}
	
	public BigIntegerVector(BigInteger aX, Vector<BigInteger> aV1) {
		final int s = aV1.size();
		mElements = new BigInteger[s+1];
		mElements[0] = aX;
		for(int i = 0; i < s; ++i) mElements[i+1] = aV1.get(i);
	}
	
	public BigIntegerVector(Vector<BigInteger> aV1, BigInteger aY) {
		final int s = aV1.size();
		mElements = new BigInteger[s+1];
		for(int i = 0; i < s; ++i) mElements[i] = aV1.get(i);
		mElements[s] = aY;
	}
	
	public BigIntegerVector(BigInteger aX, Vector<BigInteger> aV1, BigInteger aY) {
		final int s = aV1.size();
		mElements = new BigInteger[s+2];
		mElements[0] = aX;
		for(int i = 0; i < s; ++i) mElements[i+1] = aV1.get(i);
		mElements[s+1] = aY;
	}
	
	public BigIntegerVector(Vector<BigInteger> aV1, Vector<BigInteger> aV2) {
		final int s1 = aV1.size();
		final int s2 = aV2.size();
		mElements = new BigInteger[s1+s2];
		for(int i = 0; i < s1; ++i) mElements[i] = aV1.get(i);
		for(int i = 0; i < s2; ++i) mElements[i + s1] = aV2.get(i);
	}
	
	public BigIntegerVector(Vector<? extends Number> aOther) {
		final int s = aOther.size();
		mElements = new BigInteger[s];
		for(int i = 0; i < s; ++i) mElements[i] = BigInteger.valueOf(aOther.get(i).longValue());
	}
	
	// Inherited from VectorCommon

	@Override
	protected BigInteger sqrt(BigInteger aValue) {
		// \TODO Improve sqrt for values not representable by long
		return BigInteger.valueOf((long) Math.sqrt(aValue.longValue()));
	}

	@Override
	protected BigInteger add(BigInteger aA, BigInteger aB) {
		return aA.add(aB);
	}

	@Override
	protected BigInteger sub(BigInteger aA, BigInteger aB) {
		return aA.subtract(aB);
	}

	@Override
	protected BigInteger mul(BigInteger aA, BigInteger aB) {
		return aA.multiply(aB);
	}

	@Override
	protected BigInteger div(BigInteger aA, BigInteger aB) {
		return aA.divide(aB);
	}

	@Override
	protected BigInteger valueOf(int aValue) {
		return BigInteger.valueOf(aValue);
	}

	@Override
	protected BigInteger min(BigInteger aA, BigInteger aB) {
		return aA.min(aB);
	}

	@Override
	protected BigInteger max(BigInteger aA, BigInteger aB) {
		return aA.max(aB);
	}

	@Override
	protected VectorCommon<BigInteger> createVector(BigInteger[] aValues) {
		return new BigIntegerVector(aValues);
	}

	@Override
	protected BigInteger[] createArray(int aSize) {
		return new BigInteger[aSize];
	}
	
	// Inherited from Vector

	@Override
	public int size() {
		return mElements.length;
	}

	@Override
	public Vector<BigInteger> set(int aIndex, BigInteger aValue) {
		final int s = mElements.length;
		final BigInteger[] tmp = new BigInteger[s];
		for(int i = 0; i < s; ++i) tmp[i] = mElements[i];
		tmp[aIndex] = aValue;
		return new BigIntegerVector(tmp);
	}

	@Override
	public BigInteger get(int aIndex) {
		return mElements[aIndex];
	}

}
