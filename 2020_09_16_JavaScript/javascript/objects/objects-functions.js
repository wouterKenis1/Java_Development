let myBook = {
    title: "1984",
    author: "George Orwell",
    pageCount: 326,
}

let otherBook = {
    title: "A Peoples History",
    author: "Howard Zinn",
    pageCount: 723,
}

let getSummary = function(book){
    return {
        summary: `${book.title} by ${book.author}`,
        pageCountSummary: `${book.title} is ${book.pageCount} pages long`,
    }
}

let mySummary = getSummary(myBook);
let otherSummary = getSummary(otherBook);

console.log(mySummary.pageCountSummary);

// challenge
// fahrenheit -> calc celcius + kelvin -> object with all three

let getTemperatures = function(fahrenheit){
    let celcius = (fahrenheit - 32) * 5 / 9;
    let kelvin = celcius + 273.15;
    return {
        fahrenheit: fahrenheit,
        celcius: celcius,
        kelvin: kelvin,
    }
}

let obj = getTemperatures(212);
console.log(obj);

