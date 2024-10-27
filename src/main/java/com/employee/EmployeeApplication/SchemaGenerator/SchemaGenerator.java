package com.employee.EmployeeApplication.SchemaGenerator;

import com.employee.EmployeeApplication.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;

public class SchemaGenerator {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonSchemaGenerator schemaGen = new JsonSchemaGenerator(mapper);


        // Replace FacultyProfile.class with your entity class
        JsonSchema schema = schemaGen.generateSchema(Employee.class);

        // Convert to a JSON string
        String schemaString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(schema);
        System.out.println(schemaString);
    }

}
