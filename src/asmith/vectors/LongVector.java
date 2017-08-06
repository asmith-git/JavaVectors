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

public final class LongVector extends VectorCommon<Long> {
	private final long[] mElements;
	
	public LongVector(long[] aValue) {
		mElements = aValue;
	}
	
	public LongVector(Long[] aValue) {
		final int s = aValue.length;
		mElements = new long[s];
		for(int i = 0; i < s; ++i) mElements[i] = aValue[i];
	}
	
	public LongVector(long aX, long aY) {
		mElements = new long[] { aX, aY };
	}
	
	public LongVector(long aX, long aY, long aZ) {
		mElements = new long[] { aX, aY, aZ };
	}
	
	public LongVector(long aX, long aY, long aZ, long aW) {
		mElements = new long[] { aX, aY, aZ, aW };
	}	
	
	public LongVector(long aX, Vector<Long> aV1) {
		final int s = aV1.size();
		mElements = new long[s+1];
		mElements[0] = aX;
		for(int i = 0; i < s; ++i) mElements[i+1] = aV1.get(i);
	}
	
	public LongVector(Vector<Long> aV1, long aY) {
		final int s = aV1.size();
		mElements = new long[s+1];
		for(int i = 0; i < s; ++i) mElements[i] = aV1.get(i);
		mElements[s] = aY;
	}
	
	public LongVector(long aX, Vector<Long> aV1, long aY) {
		final int s = aV1.size();
		mElements = new long[s+2];
		mElements[0] = aX;
		for(int i = 0; i < s; ++i) mElements[i+1] = aV1.get(i);
		mElements[s+1] = aY;
	}
	
	public LongVector(Vector<Long> aV1, Vector<Long> aV2) {
		final int s1 = aV1.size();
		final int s2 = aV2.size();
		mElements = new long[s1+s2];
		for(int i = 0; i < s1; ++i) mElements[i] = aV1.get(i);
		for(int i = 0; i < s2; ++i) mElements[i + s1] = aV2.get(i);
	}
	
	public LongVector(Vector<? extends Number> aOther) {
		final int s = aOther.size();
		mElements = new long[s];
		for(int i = 0; i < s; ++i) mElements[i] = aOther.get(i).longValue();
	}
	
	// Inherited from VectorCommon

	@Override
	protected Long sqrt(Long aValue) {
		return (long) Math.sqrt(aValue);
	}

	@Override
	protected Long add(Long aA, Long aB) {
		return aA + aB;
	}

	@Override
	protected Long sub(Long aA, Long aB) {
		return aA - aB;
	}

	@Override
	protected Long mul(Long aA, Long aB) {
		return aA * aB;
	}

	@Override
	protected Long div(Long aA, Long aB) {
		return aA / aB;
	}

	@Override
	protected Long valueOf(int aValue) {
		return Long.valueOf(aValue);
	}

	@Override
	protected Long min(Long aA, Long aB) {
		return Math.min(aA, aB);
	}

	@Override
	protected Long max(Long aA, Long aB) {
		return Math.max(aA, aB);
	}

	@Override
	protected VectorCommon<Long> createVector(Long[] aValues) {
		return new LongVector(aValues);
	}

	@Override
	protected Long[] createArray(int aSize) {
		return new Long[aSize];
	}
	
	// Inherited from Vector

	@Override
	public int size() {
		return mElements.length;
	}

	@Override
	public Vector<Long> set(int aIndex, Long aValue) {
		final int s = mElements.length;
		final long[] tmp = new long[s];
		for(int i = 0; i < s; ++i) tmp[i] = mElements[i];
		tmp[aIndex] = aValue;
		return new LongVector(tmp);
	}

	@Override
	public Long get(int aIndex) {
		return mElements[aIndex];
	}

}
