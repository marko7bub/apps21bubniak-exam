package domain;

import json.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    protected List<Json> exams = new ArrayList<>();

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        // ToDo
        super(name, surname, year);
        for (int i = 0; i < exams.length; i++) {
            JsonObject exam = new JsonObject(new JsonPair("course", new JsonString(exams[i].key)), new JsonPair("mark", new JsonNumber(exams[i].value)), new JsonPair("passed", new JsonBoolean(exams[i].value >= 3)));
            this.exams.add(exam);
        }

    }

    @Override
    public JsonObject toJsonObject() {
        // ToDo
        JsonObject result = super.toJsonObject();
        Json[] auxilaryArray = new Json[this.exams.size()];
        this.exams.toArray(auxilaryArray);
        result.add(new JsonPair("exams", new JsonArray(auxilaryArray)));
        return result;
    }
}