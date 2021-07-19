This is a university project in agent technology course composed on 2 parts, one implementing an expert system and the other a multiagent system for flight management.

# Part 1

the part 1 of this projec implement two expert system, a first one for determinig the model of a car, and a second one as a Touristic guide in Algeria. The software can implement any expert system as long as the rules (composed by ands) are specified in a json file in Multi-Agent-system-for-flight-managment/src/part_1/bases/

## JSON File Structure

```json
{
   "title":"base of rule title",
   "but": "the goal we're trying to reach",
   "facts":{
      "_comment": "list of facts with it's possible values",
      "fact1":[
         "possible value 1",
         "possible value 2",
         "possible value 3"
      ],
      "fact2":[
         "possible value 1",
         "possible value 2",
         "possible value 3"
      ]
   },
   "rules":{
      "_comment": "list of facts with it's possible values",
      "rule1":{
         "_comment": "a rule is a set of ANDs where each AND is a condition with the following operators (==, >, >=, <, <=)",
         "AND": [
            {
               "type_operator": "operator to compare (one of the facts)",
               "operation": "==",
               "value_operator": "value (one of the possible values of the fact)" 
            },
            {
               "type_operator": "operator to compare (one of the facts)", 
               "operation": ">=",
               "value_operator": "value (one of the possible values of the fact)" 
            }
         ],
         "THEN": {
            "type_result": "Vehicle",
            "result": "Bicycle"
         }
      }
   }
}
```

more sofisticated exemples can be found in Multi-Agent-system-for-flight-managment/src/part_1/bases/

# Part 2

The part 2 of the project simulate a multi-agent flight managment app, the system is composed with multiple flight companies, each of them is represented in a JSON file in Multi-Agent-system-for-flight-managment/src/part_2/bases/

The system is composed by n+1 agents where n is the number of flight companies, each companie (and companie's JSON file) is managed by an agent, and the whole system is manages by a central agent that comunicate with the UI and with each agent company.

# Dependencies
* JAVA
* JAVAFX
* Jade
* json-20210307
* gson-2.8.7
