package alchemy.transformer;

//Generic interface for conversion
public interface Transmutation<F, T> {

    T convertToMaterials(F reagent);

    F convertFromMaterials(T reagent);

}
