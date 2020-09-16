// students score, total possible score
// 15/20 -> you got a C (75%)!
// A 100-90 B 89-80 C 79-70 D 69-60 F 59-0

let calcGrade = function(studentScore,totalPossible = 20){
    let ratio = studentScore / totalPossible * 100; // should put parentheses to ensure totalPossible * 100 isn't calculated first
    let letterGrade = "Cheater";
    if(ratio <= 100 && ratio >= 90){letterGrade = "A";}
    if(ratio < 90 && ratio >= 80){letterGrade = "B";}
    if(ratio < 80 && ratio >= 70){letterGrade = "C";}
    if(ratio < 70 && ratio >= 60){letterGrade = "D";}
    if(ratio < 60 && ratio >= 0){letterGrade = "F";}
    if(letterGrade == "Cheater"){ console.log("Cheater!! you've got an F")
    } else {
        console.log(`${studentScore}/${totalPossible} -> you got a ${letterGrade} (${ratio}%)!`)
    }
}

calcGrade(15,20);
calcGrade(99,100);
calcGrade(101,100);