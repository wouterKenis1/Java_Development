console.log("mom");

window.onload = function() {
    let combinationElements = document.getElementsByName("voteButton");
    console.log(combinationElements);
    combinationElements.forEach(element => function (element) {
        console.log("dad");
    });
}