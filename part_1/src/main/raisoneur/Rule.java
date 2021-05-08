package main.raisoneur;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class Rule implements Iterable<Condition>{

    private ArrayList<Condition> conditions;
    private String rulename, resultats, variableResultat;

    public Rule(String rulename, ArrayList<Condition> conditions, String resultats, String variableResultat) {
        this.conditions = conditions;
        this.rulename = rulename;
        this.resultats = resultats;
        this.variableResultat = variableResultat;
    }

    public Rule(String rulename, JSONObject jsonRule){
        this.rulename = rulename;
        this.JSONToRule(jsonRule);
    }

    public String getResultats() {
        return resultats;
    }

    public String getVariableResultat() {
        return variableResultat;
    }

    public void JSONToRule(JSONObject jsonRule) {

    }

    @Override
    public Iterator<Condition> iterator() {
        return conditions.iterator();
    }
}
