var Yatzy = function() {}

Yatzy.chance = function(dice) {
    return Yatzy.sumDice(dice);
}

Yatzy.yatzy = function(dice) {
    var frequencies = Yatzy.diceFrequencies(dice);
    var values = Object.keys(frequencies).map(function(key) {
                        return frequencies[key];
                    });

    return values.find((n) => n === 5) ? 50 : 0;
}

Yatzy.ones = function(dice) {
    return Yatzy.numberOfDiceFrequency(1, dice);
}

Yatzy.twos = function(dice) {
    return Yatzy.numberOfDiceFrequency(2, dice);
}

Yatzy.threes = function(dice) {
    return Yatzy.numberOfDiceFrequency(3, dice);
}

Yatzy.fours = function(dice) {
    return Yatzy.numberOfDiceFrequency(4, dice);
}

Yatzy.fives = function(dice) {
    return Yatzy.numberOfDiceFrequency(5, dice);
}

Yatzy.sixes = function(dice) {
    return Yatzy.numberOfDiceFrequency(6, dice);
}

Yatzy.score_pair = function(dice)
{
    return Yatzy.numberOfAKind(2, dice);
}

Yatzy.two_pair = function(dice)
{
    let score = 0;
    var frequencies = Yatzy.diceFrequencies(dice);
    var values = Object.keys(frequencies).map(function(key) {
                        return frequencies[key];
                    });
        if (values.filter( (n) => n >= 2).length === 2) {
            [6, 5, 4, 3, 2, 1].map( (dice_value) => {
                if (frequencies[dice_value] >= 2)
                    score += 2*dice_value;
            } );
        }
        return score;
}

Yatzy.four_of_a_kind = function(dice)
{
    return Yatzy.numberOfAKind(4, dice);
}

Yatzy.three_of_a_kind = function(dice)
{
    return Yatzy.numberOfAKind(3, dice);
}

Yatzy.smallStraight = function(dice)
{
    return (Yatzy.isStraight(dice) && Yatzy.diceFrequencies(dice)[6] === 0) ? 15 : 0;
}

Yatzy.largeStraight = function(dice)
{
    return (Yatzy.isStraight(dice) && Yatzy.diceFrequencies(dice)[6] === 1) ? 20 : 0;
}

Yatzy.fullHouse = function(dice)
{
    const frequencies = Yatzy.diceFrequencies(dice);
    var values = Object.keys(frequencies).map(function(key) {
                        return frequencies[key];
                    });
    if (values.find( (n) => n === 3) 
            && values.find( (n) => n === 2))
       return Yatzy.sumDice(dice);
    else
       return 0;
}

Yatzy.diceFrequencies = function(dice){
    let facesCount = {1:0, 2:0, 3:0, 4:0, 5:0, 6:0};
    dice.forEach(number => facesCount[number]++);
    return facesCount;
}

Yatzy.numberOfDiceFrequency = function(number, dice){
    return Yatzy.diceFrequencies(dice)[number]*number;
}

Yatzy.numberOfAKind = function(number, dice){
    const frequencies = Yatzy.diceFrequencies(dice);

    let scores = [6, 5, 4, 3, 2, 1].map( (maxFace) => {
        if (frequencies[maxFace] >= number)
            return number*maxFace;
        else
            return 0;
    } );

    scores = scores.filter( (score) => score > 0);

    return scores.length > 0 ? scores[0] : 0;
}

Yatzy.isStraight = function(dice){
    var frequencies = Yatzy.diceFrequencies(dice);
    var values = Object.keys(frequencies).map(function(key) {
                        return frequencies[key];
                    });

    return values.filter( (value) => value === 1).length === 5;
}

Yatzy.sumDice = function(dice){
    let sumValues = 0;
    dice.forEach(value => sumValues += value);
    return sumValues;
}

module.exports = Yatzy;