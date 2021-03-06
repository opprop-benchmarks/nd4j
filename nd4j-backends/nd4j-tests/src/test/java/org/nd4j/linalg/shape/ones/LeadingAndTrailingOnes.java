package org.nd4j.linalg.shape.ones;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.nd4j.linalg.BaseNd4jTest;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.factory.Nd4jBackend;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Adam Gibson
 */
@RunWith(Parameterized.class)
public class LeadingAndTrailingOnes extends BaseNd4jTest {

    public LeadingAndTrailingOnes(Nd4jBackend backend) {
        super(backend);
    }

    @Test
    public void testSliceConstructor() throws Exception {
        List<INDArray> testList = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            testList.add(Nd4j.scalar(i + 1));

        INDArray test = Nd4j.create(testList, new int[] {1, testList.size()});
        INDArray expected = Nd4j.create(new float[] {1, 2, 3, 4, 5}, new int[] {1, 5});
        assertEquals(expected, test);
    }

    @Test
    public void testLeadAndTrail() {
        INDArray fourD = Nd4j.create(1, 2, 1, 1);
        assertEquals(2, fourD.length());
        for (int i = 0; i < fourD.length(); i++)
            assertEquals(0.0, fourD.getDouble(i), 1e-1);

    }

    @Test
    public void testCreateLeadingAndTrailingOnes() {
        INDArray arr = Nd4j.create(1, 10, 1, 1);
        arr.assign(1);
        arr.toString();
        System.out.println(arr);
    }


    @Override
    public char ordering() {
        return 'f';
    }
}
