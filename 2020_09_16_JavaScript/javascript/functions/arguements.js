// multiple arguements
let add = function(a, b, c){
    return a + b + c;
}

let result = add(10, 1, 5);
console.log(result);

// default arguements
// IMPORTANT: TEMPLATE STRING ONLY WORKS WITH `` (above R-Shift) NOT WITH '' OR ""
let getScoreText = function(name = "___", score = 0){
    //return "Name: " + name + " - Score: " + score;
    return `Name: ${name} - Score: ${score}`;
}

let text = getScoreText();
console.log(text);

text = getScoreText("Andrew");
console.log(text);

text = getScoreText(undefined,100);
console.log(text);

text = getScoreText("Andrew", 100);
console.log(text);

// challenge
// TipCalc
let tipCalc = function(total, tipRatio = 0.2){
    return total * tipRatio;
}

let value1 = 100;
console.log(tipCalc(value1));
console.log(tipCalc(value1,0.3));
let value2 = 200;
console.log(tipCalc(value2));
console.log(tipCalc(value2,0.3));

let getTipText = function(total, tipRatio = 0.2){
    let tip = total*tipRatio;
    tipRatio = tipRatio * 100;
    return `A ${tipRatio}% tip on €${total} would be €${tip}.`
}

console.log(getTipText(100));
console.log(getTipText(200,0.5));