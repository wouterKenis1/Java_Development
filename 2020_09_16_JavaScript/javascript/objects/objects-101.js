let myBook = {
    title: "1984",
    author: "George Orwell",
    pageCount: 326,
}

console.log(myBook);
console.log(myBook.title);
console.log(`${myBook.title} by ${myBook.author}`)

myBook.title = "Animal Farm";


console.log(myBook);
console.log(myBook.title);
console.log(`${myBook.title} by ${myBook.author}`)


// Challenge
// name, age, location
// Andrew is 27 and lives in Philadelphia
// increase age by 1 and print again
console.clear();

let person = {
    name: "Wouter",
    age: 23,
    location: "Mechelen",
}

let printPerson = function(person){
    console.log(`${person.name} is ${person.age} and lives in ${person.location}`);
}

printPerson(person);
person.age++;
printPerson(person);



