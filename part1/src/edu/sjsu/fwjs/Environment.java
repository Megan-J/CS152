package edu.sjsu.fwjs;

import java.util.Map;
import java.util.HashMap;

public class Environment {
    private Map<String,Value> env = new HashMap<String,Value>();
    private Environment outerEnv;

    /**
     * Constructor for global environment
     */
    public Environment() {}

    /**
     * Constructor for local environment of a function
     */
    public Environment(Environment outerEnv) {
        this.outerEnv = outerEnv;
    }

    /**
     * Handles the logic of resolving a variable.
     * If the variable name is in the current scope, it is returned.
     * Otherwise, search for the variable in the outer scope.
     * If we are at the outermost scope (AKA the global scope)
     * null is returned (similar to how JS returns undefined.
     */
    public Value resolveVar(String varName) {

        // creating a local environment
        Environment locEnv = new Environment(this);

        // have to cycle through scopes starting with local
        while((locEnv != null) && (locEnv.env.get(varName) == null)){
            locEnv = locEnv.outerEnv;
        }

        if(locEnv == null){
            return new NullVal();
        }
        else {
            return locEnv.env.get(varName);
        }
    }

    /**
     * Used for updating existing variables.
     * If a variable has not been defined previously in the current scope,
     * or any of the function's outer scopes, the var is stored in the global scope.
     */
    public void updateVar(String key, Value v) {
        // this is local scope
        if(env.containsKey(key)) {
            env.put(key, v);
        }
        // this is outer scope
        else if(this.outerEnv != null && this.outerEnv.resolveVar(key) != null){
            this.outerEnv.updateVar(key, v);

        }
        // global scope bc outEnv has to be null for global
        else {
            this.env.put(key, v);
        }
    }

    /**
     * Creates a new variable in the local scope.
     * If the variable has been defined in the current scope previously,
     * a RuntimeException is thrown.
     */
    public void createVar(String key, Value v) {
        if(this.env.containsKey(key)) {
          throw new RuntimeException("Variable has been defined in the current scope previously");
        }
        this.env.put(key, v);
    }
}
