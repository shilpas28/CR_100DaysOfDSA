//Leetcode
//2115. Find All Possible Recipes from Given Supplies - Depth-First Search (DFS)
//Time complexity: O(n+m+s)
//Space complexity: O(n+m) 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindAllPossibleRecipesFromGivenSupplies_2 {

    public static void main(String[] args) {
        String[] recipes = { "bread", "sandwich" };
        List<List<String>> ingredients = new ArrayList<List<String>>();
        ingredients.add(new ArrayList<>(Arrays.asList("yeast", "flour")));
        ingredients.add(new ArrayList<>(Arrays.asList("bread", "meat")));
        String[] supplies = { "yeast", "flour", "meat" };
        System.out.println(findAllRecipes(recipes, ingredients, supplies));
    }

    public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> possibleRecipes = new ArrayList<>();
        // Track if ingredient/recipe can be made
        Map<String, Boolean> canMake = new HashMap<>();
        // Map recipe name to its index in ingredients list
        Map<String, Integer> recipeToIndex = new HashMap<>();
        // Mark all initial supplies as available
        for (String supply : supplies) {
            canMake.put(supply, true);
        }
        // Create recipe to index mapping
        for (int idx = 0; idx < recipes.length; idx++) {
            recipeToIndex.put(recipes[idx], idx);
        }
        // Try to make each recipe using DFS
        for (String recipe : recipes) {
            checkRecipe(
                    recipe,
                    ingredients,
                    new HashSet<String>(),
                    canMake,
                    recipeToIndex);
            if (canMake.get(recipe)) {
                possibleRecipes.add(recipe);
            }
        }

        return possibleRecipes;
    }

    static void checkRecipe(
            String recipe,
            List<List<String>> ingredients,
            Set<String> visited,
            Map<String, Boolean> canMake,
            Map<String, Integer> recipeToIndex) {
        // Return if we already know if recipe can be made
        if (canMake.containsKey(recipe) && canMake.get(recipe)) {
            return;
        }
        // Not a valid recipe or cycle detected
        if (!recipeToIndex.containsKey(recipe) || visited.contains(recipe)) {
            canMake.put(recipe, false);
            return;
        }

        visited.add(recipe);
        // Check if we can make all required ingredients
        List<String> neededIngredients = ingredients.get(
                recipeToIndex.get(recipe));
        for (String ingredient : neededIngredients) {
            checkRecipe(
                    ingredient,
                    ingredients,
                    visited,
                    canMake,
                    recipeToIndex);
            if (!canMake.get(ingredient)) {
                canMake.put(recipe, false);
                return;
            }
        }
        // All ingredients can be made
        canMake.put(recipe, true);
    }
}
