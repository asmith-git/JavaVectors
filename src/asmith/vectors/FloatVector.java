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

public final class FloatVector extends VectorCommon<Float> {
	private final float[] mElements;
	
	public FloatVector(float[] aValue) {
		mElements = aValue;
	}
	
	public FloatVector(Float[] aValue) {
		final int s = aValue.length;
		mElements = new float[s];
		for(int i = 0; i < s; ++i) mElements[i] = aValue[i];
	}
	
	public FloatVector(float aX, float aY) {
		mElements = new float[] { aX, aY };
	}
	
	public FloatVector(float aX, float aY, float aZ) {
		mElements = new float[] { aX, aY, aZ };
	}
	
	public FloatVector(float aX, float aY, float aZ, float aW) {
		mElements = new float[] { aX, aY, aZ, aW };
	}	
	
	public FloatVector(float aX, Vector<Float> aV1) {
		final int s = aV1.size();
		mElements = new float[s+1];
		mElements[0] = aX;
		for(int i = 0; i < s; ++i) mElements[i+1] = aV1.get(i);
	}
	
	public FloatVector(Vector<Float> aV1, float aY) {
		final int s = aV1.size();
		mElements = new float[s+1];
		for(int i = 0; i < s; ++i) mElements[i] = aV1.get(i);
		mElements[s] = aY;
	}
	
	public FloatVector(float aX, Vector<Float> aV1, float aY) {
		final int s = aV1.size();
		mElements = new float[s+2];
		mElements[0] = aX;
		for(int i = 0; i < s; ++i) mElements[i+1] = aV1.get(i);
		mElements[s+1] = aY;
	}
	
	public FloatVector(Vector<Float> aV1, Vector<Float> aV2) {
		final int s1 = aV1.size();
		final int s2 = aV2.size();
		mElements = new float[s1+s2];
		for(int i = 0; i < s1; ++i) mElements[i] = aV1.get(i);
		for(int i = 0; i < s2; ++i) mElements[i + s1] = aV2.get(i);
	}
	
	public FloatVector(Vector<? extends Number> aOther) {
		final int s = aOther.size();
		mElements = new float[s];
		for(int i = 0; i < s; ++i) mElements[i] = aOther.get(i).floatValue();
	}
	
	// Inherited from VectorCommon

	@Override
	protected Float sqrt(Float aValue) {
		return (float) Math.sqrt(aValue);
	}

	@Override
	protected Float add(Float aA, Float aB) {
		return aA + aB;
	}

	@Override
	protected Float sub(Float aA, Float aB) {
		return aA - aB;
	}

	@Override
	protected Float mul(Float aA, Float aB) {
		return aA * aB;
	}

	@Override
	protected Float div(Float aA, Float aB) {
		return aA / aB;
	}

	@Override
	protected Float valueOf(int aValue) {
		return Float.valueOf(aValue);
	}

	@Override
	protected Float min(Float aA, Float aB) {
		return Math.min(aA, aB);
	}

	@Override
	protected Float max(Float aA, Float aB) {
		return Math.max(aA, aB);
	}

	@Override
	protected VectorCommon<Float> createVector(Float[] aValues) {
		return new FloatVector(aValues);
	}

	@Override
	protected Float[] createArray(int aSize) {
		return new Float[aSize];
	}
	
	// Inherited from Vector

	@Override
	public int size() {
		return mElements.length;
	}

	@Override
	public Vector<Float> set(int aIndex, Float aValue) {
		final int s = mElements.length;
		final float[] tmp = new float[s];
		for(int i = 0; i < s; ++i) tmp[i] = mElements[i];
		tmp[aIndex] = aValue;
		return new FloatVector(tmp);
	}

	@Override
	public Float get(int aIndex) {
		return mElements[aIndex];
	}

}
