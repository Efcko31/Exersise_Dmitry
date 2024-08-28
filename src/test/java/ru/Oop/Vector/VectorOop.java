package ru.Oop.Vector;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VectorOop {

    private int x;
    private int y;
    private int z;

    public double calculateLengthVector() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public int calculateScalarProductVectors(VectorOop vector) {
        return x * vector.x + y * vector.y + z * vector.z;
    }

    public VectorOop vectorProductWithAnotherVector(VectorOop vector) {
        return new VectorOop(
                y * vector.z - z * vector.y,
                z * vector.x - x * vector.z,
                x * vector.y - y * vector.x
        );
    }
}
