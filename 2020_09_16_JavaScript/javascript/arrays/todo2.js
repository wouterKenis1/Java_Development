todos = [
    {
        text: "order cat food",
        completed: true,
    },
    {
        text: "clean the kitchen",
        completed: false,
    },
    {
        text: "buy food",
        completed: false,
    },
    {
        text:  "do work",
        completed: true,
    },
    {
        text:  "exercise",
        completed: true,
    },
]


const getThingsToDo = function(todos){
    return todos.filter(function(todo,index){
        return !todo.completed;
    })
}


console.log(getThingsToDo(todos));

console.log("-----  -----")
todos = [
    {
        text: "order cat food",
        completed: true,
    },
    {
        text: "clean the kitchen",
        completed: false,
    },
    {
        text: "buy food",
        completed: false,
    },
    {
        text:  "do work",
        completed: true,
    },
    {
        text:  "exercise",
        completed: true,
    },
]

const sortToDos = function(todos){
    todos.sort(function(a,b){
        if(a.completed && !b.completed){ return -1;}
        if(!a.completed && b.completed){ return 1;}
        else{ return 0;}
    })
}

console.log(todos);
sortToDos(todos);
console.log(todos);

