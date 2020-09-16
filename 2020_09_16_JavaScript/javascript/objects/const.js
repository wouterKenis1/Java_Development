const isRaining = true;
const person = {
    age: 23,
}
//isRaining = false;
console.log(person);
person.age = 24; // legal
console.log(person);
//person = {}; // illegal
console.log(person);

console.log(isRaining);