// global scope (convertFtoC)
  // local scope (fahrenheit, celcius)
    // local scope (isFreezing)
let convertFtoC = function(fahrenheit){
    let celcius = (fahrenheit - 32) * 5 / 9;
    if(celcius <= 0){
        let isFreezing = true;
    }
    return celcius;
}