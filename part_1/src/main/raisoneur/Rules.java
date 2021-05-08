package main.raisoneur;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class Rules implements Iterable<Rule>{

    private final ArrayList<Rule> rules;

    public Rules() {
        this.rules = new ArrayList<>();
    }

    public Rules(JSONObject jsonRules) {
        this();
        this.JSONToRules(jsonRules);
    }

    public void addRule(Rule rule){
        this.rules.add(rule);
    }

    @Override
    public Iterator<Rule> iterator() {
        return rules.iterator();
    }

    public void JSONToRules(JSONObject jsonRules) {

    }
}
