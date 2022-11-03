package com.demos.bnta.word_guesser.services;

import com.demos.bnta.word_guesser.models.*;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GameService {

    @Autowired
    WordService wordService;

    private String currentWord;
    private ArrayList<String> guessedLetters;

    private ArrayList<Game> games;

    public GameService() {
        this.games = new ArrayList<>();
    }


    public String getCurrentWord() {
        return currentWord;
    }

    public void setCurrentWord(String currentWord) {
        this.currentWord = currentWord;
    }

    public ArrayList<String> getGuessedLetters() {
        return guessedLetters;
    }

    public void setGuessedLetters(ArrayList<String> guessedLetters) {
        this.guessedLetters = guessedLetters;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }

    public void addGame(Game game){
        this.games.add(game);
    }

    public Reply processGuess(Guess guess, int id){

        // Find the correct game
        Game game = this.games.get(id - 1) ;

        // Check if game is already complete
        if (game.isComplete()){
            return new Reply(
                    false,
                    game.getWord(),
                    String.format("Already finished game %d", game.getId())
            );
        }

        // Check if letter has been guessed already
        if (this.guessedLetters.contains(guess.getLetter())){
            return new Reply(false, this.currentWord, String.format("Already guessed %s", guess.getLetter()));
        }

        // Only increment guess count if a new letter is chosen
        incrementGuesses(game);

        // Check for incorrect guess
        if (!game.getWord().contains(guess.getLetter())){
            this.guessedLetters.add(guess.getLetter());
            return new Reply(
                    false,
                    this.currentWord,
                    String.format("%s is not in the word", guess.getLetter())
            );
        }

        // Add letter to previous guesses
        this.guessedLetters.add(guess.getLetter());


        // Handle correct guess
        String runningResult = game.getWord();

        for (Character letter : game.getWord().toCharArray()) {
            if (!this.guessedLetters.contains(letter.toString())){
                runningResult = runningResult.replace(letter, '*');
            }
        }

        setCurrentWord(runningResult);

        // Check for win
        if (checkWinCondition(game)){
            game.setComplete(true);
            return new Reply(true, this.currentWord, "You win!");
        } else {
            return new Reply(true, this.currentWord,
                    String.format("%s is in the word", guess.getLetter()));
        }
    }

    private boolean checkWinCondition(Game game){
        return game.getWord().equals(this.currentWord);
    }

    private void incrementGuesses(Game game){
        game.setGuesses(game.getGuesses() + 1);
    }

    public Reply startNewGame(){
        String targetWord = wordService.getRandomWord();
        Game game = new Game(targetWord);
        this.currentWord = Strings.repeat("*", targetWord.length());
        this.guessedLetters = new ArrayList<>();
        addGame(game);
        return new Reply(
                false,
                this.currentWord,
                String.format("Started new game with id %d", game.getId())
        );
    }

}
