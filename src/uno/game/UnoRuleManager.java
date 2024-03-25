package uno.game;

import uno.rule.Rule;

import java.util.ArrayList;
import java.util.List;

public class UnoRuleManager {

    // A list of rules to apply to the game
    private List<Rule> rules;

    // A reference to the game engine
    private UnoGameEngine game;

    public UnoRuleManager(UnoGameEngine game) {
        this.game = game;
        this.rules = new ArrayList<>();
    }

    // Apply all the rules to the game state
    public void applyRules() {
        for (Rule rule : rules) {
            rule.apply(game);
        }
    }



    // Add a rule to the game
    public void addRule(Rule rule) {
        if (rule == null) {
            throw new IllegalArgumentException("Cannot add null rule to game");
        }
        rules.add(rule);
    }

    // Apply one rule to the game state
    public void applyRule(Rule rule) {
        if (rule == null) {
            throw new IllegalArgumentException("Cannot apply null rule to game");
        }
        rule.apply(game);
    }
}
