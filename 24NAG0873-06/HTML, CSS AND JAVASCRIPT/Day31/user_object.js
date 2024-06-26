let user = {
    name: "John Doe",
    email: "johndoe@example.com",
    age: 25
};

function changeName(newName){
    user.name = newName;
}

function updateEmail(newEmail){
    user.email = newEmail;
}

function calculateBirthYear(){
    let currentYear = new Date().getFullYear();
    return currentYear - user.age
}

console.log("Original user:", user);

changeName("Jane Smith");
console.log("After name change:", user);

updateEmail("janesmith@example.com");
console.log("After email update:", user);

let birthYear = calculateBirthYear();
console.log("User's birth year:", birthYear);