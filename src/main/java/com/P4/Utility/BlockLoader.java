package com.P4.Utility;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.material.Material;
import scala.tools.nsc.doc.model.Constructor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Nete on 16-02-2016.
 */
public class BlockLoader extends ClassLoader {
    Class<?> cls;

    public BlockLoader (String path)
    {
        loadBlock(path);
    }

    public Block getBlock()
    {
        try {
            return (Block) cls.newInstance();
        } catch (IllegalAccessException e)
        {
            return null;
        } catch (InstantiationException e)
        {
            return null;
        }

    }

    private void loadBlock (String path)
    {
        try {
            //Opens the inputstream and reads to a byte array
            InputStream iStream = new FileInputStream(path);
            byte raw[] = new byte[iStream.available()];
            iStream.read(raw);

            cls = this.defineClass(null, raw, 0, raw.length);
        }catch (IOException ioe)
        {
            //Poor exception handling
        }
    }
}
