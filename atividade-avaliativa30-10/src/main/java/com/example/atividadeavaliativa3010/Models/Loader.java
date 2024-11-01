package com.example.atividadeavaliativa3010.Models;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Loader {
    private static final String FILE_NAME = "save.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private Loader(){};
    public static void save(List<Produto> produtos) throws Exception {
        objectMapper.writeValue(new File(FILE_NAME), produtos);
    }

}
