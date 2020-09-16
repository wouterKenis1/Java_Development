let name = "Wouter Kenis";

// length property
console.log(name.length);

// convert to upper
console.log(name.toUpperCase());

// convert to lower
console.log(name.toLowerCase());

// includes
let password = "thisisApassword7586425!";
let test = password.includes("password");
console.log(test);

// trim
let str = " this is a string ";
console.log(str);
console.log(str.trim());


// challenge
// isValidPassword
// 8+ chars, doesn't contain password
let isValidPassword = function(str){
    return (!str.includes("password") && str.length >= 8 );
}

console.log(isValidPassword("asdfp"));
console.log(isValidPassword("abc123!çà&é"));
console.log(isValidPassword("asdfpasswordrandom"));

