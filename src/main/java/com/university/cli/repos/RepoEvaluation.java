package com.university.cli.repos;

import com.university.cli.CRUDRepository;
import com.university.evaluation.Evaluation;

import java.util.HashMap;
import java.util.Map;

public class RepoEvaluation implements CRUDRepository<Evaluation> {

    private final Map<Integer, Evaluation> evaluations = new HashMap<>();

    public RepoEvaluation() {

    }

    @Override
    public void create(Evaluation evaluation) {
        if (evaluations.containsKey(evaluation.getId())) {
            throw new IllegalArgumentException("Evaluation ID " + evaluation.getId() + " already exists.");
        }
        evaluations.put(evaluation.getId(), evaluation);
    }

    @Override
    public Evaluation read(int id) {
        Evaluation evaluation = evaluations.get(id);
        if (evaluation == null) {
            throw new RuntimeException("Evaluation with ID " + id + " not found.");
        }
        return evaluation;
    }

    @Override
    public void update(int id, Evaluation evaluation) {
        if (!evaluations.containsKey(id)) {
            throw new RuntimeException("Evaluation with ID " + id + " not found.");
        }
        evaluations.put(id, evaluation);
    }

    @Override
    public void delete(int id) {
        if (!evaluations.containsKey(id)) {
            throw new RuntimeException("Evaluation with ID " + id + " not found.");
        }
        evaluations.remove(id);
    }

    @Override
    public String getIdentifier() {
        return "Evaluation";
    }

    @Override
    public Class<Evaluation> getEntityClass() {
        return Evaluation.class;
    }
}
