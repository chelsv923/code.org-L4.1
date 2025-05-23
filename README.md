# FlixRate App

The `UserRatingsScreen` is supposed to show the user's name and the list of movies they have rated, along with the ratings they gave each movie. Currently, when you click the **View Your Ratings** button, we just see this empty window.

![user ratings screen](assets/lesson3a-01.png)

But what we want is to show the current user's name, the list of movies the user has rated, and the corresponding scores the user gave each movie.

![corrected user ratings screen](assets/lesson3a-02.png)

Additionally, some of the functionality involving switching users isn't working properly.

Before implementing the logic for your app:

1. Take a moment to review the README to understand the code that is provided and tasks that need to be completed.
2. Decide with your partner which tasks each of you will complete on your individual branches. As you work, remember to commit your code after completing a task!

## Step 1: Understanding the Code

Before we start modifying this code, we should first make sure we understand what it currently does. Take a moment to read through the code. For any parts that you're unsure of, highlight the code and right-click, then choose **Copilot > Explain This**.

![using Copilot to explain code](assets/lesson3a-03.png)

Copilot will generate an explanation of the code you highlighted in the chat panel. Be sure also to ask follow-up questions if you need additional clarification on the code.

## Step 2: Breaking Down the Problem

AI code-generators like Copilot are most effective when the task you want them to do is clear and specific. Before asking Copilot what code you need to solve this problem, outline the steps the program needs to take to implement the desired functionality.
Remember, the user wants to see the movies they have rated and the score they gave each movie when they click the **View Your Ratings** button.

✅ **Do This:** With your partner, plan the steps the app needs to take. This can be in the form of pseudocode, a flowchart, sketches, or any other representation you choose.

//STEPS 
// When the user taps “View Your Ratings”:
onViewRatingsButtonClicked() {
  // 1. Retrieve the currently-logged-in user
  User currentUser = UserSession.getCurrentUser();
  
  // 2. Fetch that user’s ratings from the data layer
  List<Rating> userRatings = RatingsRepository.getRatingsForUser(currentUser.getId());
  
  // 3. Update the header to show “Ratings for <User’s Name>”
  headerTextView.setText("Ratings for " + currentUser.getName());
  
  // 4. Clear any existing entries in the ratings list container
  ratingsContainer.removeAllViews();
  
  // 5. For each Rating:
  for (Rating r : userRatings) {
    //   a) Inflate or create a row view
    View row = inflater.inflate(R.layout.rating_row, ratingsContainer, false);
    //   b) Set the movie title text
    ((TextView) row.findViewById(R.id.movieTitle)).setText(r.getMovieTitle());
    //   c) Set the rating score text
    ((TextView) row.findViewById(R.id.movieScore)).setText(String.valueOf(r.getScore()));
    //   d) Add the row to the container
    ratingsContainer.addView(row);
  }
}

// When the app switches to a different user:
onUserSwitched() {
  // Re-run the same logic:
  onViewRatingsButtonClicked();
}


## Step 3: Planning the Prompt

✅ **Do This:** Based on the steps you've outlined, what code do we need to ask Copilot for? With your partner, plan the prompt you want to ask Copilot.

Write your prompt here!
//Prompt:
//In the android app in Java with a UserRatingsScreen Activity (or Fragment): When the user taps the View Your Ratings button, please modify code so that:
//Get the current user from UserSession.
//Load their list of Rating objects from RatingsRepository.
//Set a header TextView to Ratings for <username>.
//Clear my LinearLayout or RecyclerView adapter.
//For each rating, inflate a row layout containing a movie title TextView and a score TextView, then add it to the container.
//6. Additionally ,when the app’s current user changes, I want to automatically refresh that list.
//Please provide the Java code inside the Activity/Fragment to implement that logic in the button’s onClick handler and in a user-switch listener.


> &nbsp;
> **Tip!**
>
> Try starting your prompt with `"Modify the createListView() method to"` followed by the steps that need to be added to this method.
> &nbsp;

## Step 4: Evaluating the Code

AI code-generating tools like Copilot are not always right and sometimes even suggest code that is redundant or inefficient. Before adding its suggestion to the program, let's check if it makes sense and aligns with what we're expecting.

✅ **Do This:** With your partner, trace the code Copilot suggested as a solution. This can be in the form of a numbered or bulleted list, a flowchart, a drawing, or any other representation you choose.

Trace your code here!
//viewRatingsButton.setOnClickListener(v -> {
 // User user = UserSession.getCurrentUser();
 // List<Rating> ratings = RatingsRepository.getRatingsForUser(user.getId());

 // usernameHeader.setText("Ratings for " + user.getName());
 // ratingsContainer.removeAllViews();

//  for (Rating r : ratings) {
  //  View row = getLayoutInflater().inflate(R.layout.rating_row, ratingsContainer, false);
  //  TextView title = row.findViewById(R.id.movieTitle);
  //  TextView score = row.findViewById(R.id.movieScore);

  //  title.setText(r.getMovie().getTitle());
  //  score.setText(String.valueOf(r.getScore()));
  //  ratingsContainer.addView(row);
  }
//});

//  listening for user changes:
//UserSession.addOnUserChangeListener(newUser -> {
  // duplicate code: maybe call the button’s click listener manually
//  viewRatingsButton.performClick();
//});


Based on your analysis, would the code it suggested make sense as a solution to the problem? Why or why not?

Write your response here!
//Yes but I would not call performClick() and instead use a method like renderUserRatings()) and use it for both the user switch callback and the button listener.

If the code it suggested does **not** make sense as a solution, what needs to be improved - the steps you outlined to solve the problem or the prompt you gave Copilot? What modifications do you need to make?

Write your response here!

**🔁 Repeat this process until you feel confident you have a working solution!**

## Step 5: Testing the Code

So the code it gave makes sense . . . now what?? Well, let's add it to our program and see if it works!

✅ **Do This:** Update the `UserRatingsScreen` `WelcomeScreen` classes with the code that needs to be added to implement the desired functionality.

**Partner A & Partner B:** After implementing your solution, submit a pull request to merge your branches to the main branch. Partner A should then review Partner B's pull request, while Partner B should then review Partner A's pull request.

1. **Partner B:** Navigate to the repo on GitHub and go to the Pull requests tab. Click the New pull request button to start a pull request.
2. **Partner B:** Provide a title and brief description, and select Partner A as the reviewer.
3. **Partner A:** Navigate to the repo on GitHub and go to the Pull requests tab. Click the New pull request button to start a pull request to merge your branch to main.
4. **Partner A:** Provide a title and brief description, and select Partner B as the reviewer.

### Reviewing the PR

1. Go to the **Pull Requests** tab and select your partner's pull request from the list.
2. Click the **Files Changed** tab and go through the changes line by line. For each change, you can click on the line number to add a comment about the line.
3. When you're done reviewing, write a summary comment to give overall feedback about the changes.
   * If changes are needed, be sure to specify what changes your partner needs to make and select **Request changes** to send it back for updates.
   * If everything looks good, select **Approve**. On the **Conversation** tab, click the green button to merge the pull request. Click the **Delete branch** button after the merge is complete.

Switch to the `main` branch after merging both branches, and test the app (run `App.java`)! Rate a few movies, then check if clicking the **View Your Ratings** button displays the list of movies you rated and the scores you gave each movie. Did it work? Why or why not? What about when you try to switch users?

Write your response here!

If the app does **not** work as expected, what is it doing or **not** doing?

Write your response here!

**🔁 If the app doesn't work as expected, follow the process you used in Steps 2 through 5 to break down the problem, plan the prompt to ask Copilot, evaluate the code it suggests, and implement and test its suggestion.**
