package com.moyas1009.mnarutomod.capabilities;

public class Chakra implements IChakra
{
    private float chakra = 250F;
    @Override
    public void consume(float points)
    {
        this.chakra -= points;
        if (this.chakra < 0.0f)
        {
            this.chakra = 0.0f;
        }
    }

    @Override
    public void fill(float points)
    {
        this.chakra += points;
    }

    @Override
    public void set(float points)
    {
        this.chakra = points;
    }

    @Override
    public float getChakra() {
        return chakra;
    }
}
