package org.nd4j.autodiff.functions.impl.binary.transform.scalar;

import org.nd4j.autodiff.ArrayField;
import org.nd4j.autodiff.functions.AbstractScalarFunction;
import org.nd4j.autodiff.functions.Differential;
import org.nd4j.autodiff.functions.DifferentialFunction;
import org.nd4j.autodiff.samediff.SameDiff;

import java.util.Arrays;
import java.util.List;

public class ScalarRDiv extends AbstractScalarFunction {

    public ScalarRDiv() {
    }

    public ScalarRDiv(SameDiff sameDiff, DifferentialFunction i_v, int[] shape, Object[] extraArgs) {
        super(sameDiff, i_v, shape, extraArgs);
    }

    public ScalarRDiv(SameDiff sameDiff, DifferentialFunction i_v, Object[] extraArgs) {
        super(sameDiff, i_v, extraArgs);
    }

    public ScalarRDiv(SameDiff sameDiff, DifferentialFunction i_v, boolean inPlace, Object[] extraArgs) {
        super(sameDiff,i_v,inPlace,extraArgs);
    }




    /**
     * Get the value of this function
     *
     * @return
     */
    @Override
    public ArrayField doGetValue() {
        if(scalarValue == null) {
            scalarValue = (Number) extraArgs[0];
        }

        if(isInPlace())
            return arg().getValue(true).rdiv(scalarValue.doubleValue());
        else
            return arg().getValue(true).rdivi(scalarValue.doubleValue());

    }
    @Override
    public String functionName() {
        return new org.nd4j.linalg.api.ops.impl.scalar.ScalarReverseDivision().name();
    }

    @Override
    public List<DifferentialFunction> doDiff(List<DifferentialFunction> i_v1) {
        DifferentialFunction g = f().rdiv(f().mul(i_v1.get(0),scalarValue.doubleValue()),f().pow(arg(),2.0));

        return Arrays.asList(g);
    }
}
