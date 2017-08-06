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

public final class DoubleVector extends VectorCommon<Double> {
	private final double[] mElements;
	
	public DoubleVector(double[] aValue) {
		mElements = aValue;
	}
	
	public DoubleVector(Double[] aValue) {
		final int s = aValue.length;
		mElements = new double[s];
		for(int i = 0; i < s; ++i) mElements[i] = aValue[i];
	}
	
	public DoubleVector(double aX, double aY) {
		mElements = new double[] { aX, aY };
	}
	
	public DoubleVector(double aX, double aY, double aZ) {
		mElements = new double[] { aX, aY, aZ };
	}
	
	public DoubleVector(double aX, double aY, double aZ, double aW) {
		mElements = new double[] { aX, aY, aZ, aW };
	}	
	
	public DoubleVector(double aX, Vector<Double> aV1) {
		final int s = aV1.size();
		mElements = new double[s+1];
		mElements[0] = aX;
		for(int i = 0; i < s; ++i) mElements[i+1] = aV1.get(i);
	}
	
	public DoubleVector(Vector<Double> aV1, double aY) {
		final int s = aV1.size();
		mElements = new double[s+1];
		for(int i = 0; i < s; ++i) mElements[i] = aV1.get(i);
		mElements[s] = aY;
	}
	
	public DoubleVector(double aX, Vector<Double> aV1, double aY) {
		final int s = aV1.size();
		mElements = new double[s+2];
		mElements[0] = aX;
		for(int i = 0; i < s; ++i) mElements[i+1] = aV1.get(i);
		mElements[s+1] = aY;
	}
	
	public DoubleVector(Vector<Double> aV1, Vector<Double> aV2) {
		final int s1 = aV1.size();
		final int s2 = aV2.size();
		mElements = new double[s1+s2];
		for(int i = 0; i < s1; ++i) mElements[i] = aV1.get(i);
		for(int i = 0; i < s2; ++i) mElements[i + s1] = aV2.get(i);
	}
	
	public DoubleVector(Vector<? extends Number> aOther) {
		final int s = aOther.size();
		mElements = new double[s];
		for(int i = 0; i < s; ++i) mElements[i] = aOther.get(i).doubleValue();
	}
	
	// Inherited from VectorCommon

	@Override
	protected Double sqrt(Double aValue) {
		return Math.sqrt(aValue);
	}

	@Override
	protected Double add(Double aA, Double aB) {
		return aA + aB;
	}

	@Override
	protected Double sub(Double aA, Double aB) {
		return aA - aB;
	}

	@Override
	protected Double mul(Double aA, Double aB) {
		return aA * aB;
	}

	@Override
	protected Double div(Double aA, Double aB) {
		return aA / aB;
	}

	@Override
	protected Double valueOf(int aValue) {
		return Double.valueOf(aValue);
	}

	@Override
	protected Double min(Double aA, Double aB) {
		return Math.min(aA, aB);
	}

	@Override
	protected Double max(Double aA, Double aB) {
		return Math.max(aA, aB);
	}

	@Override
	protected VectorCommon<Double> createVector(Double[] aValues) {
		return new DoubleVector(aValues);
	}

	@Override
	protected Double[] createArray(int aSize) {
		return new Double[aSize];
	}
	
	// Inherited from Vector

	@Override
	public int size() {
		return mElements.length;
	}

	@Override
	public Vector<Double> set(int aIndex, Double aValue) {
		final int s = mElements.length;
		final double[] tmp = new double[s];
		for(int i = 0; i < s; ++i) tmp[i] = mElements[i];
		tmp[aIndex] = aValue;
		return new DoubleVector(tmp);
	}

	@Override
	public Double get(int aIndex) {
		return mElements[aIndex];
	}

}
