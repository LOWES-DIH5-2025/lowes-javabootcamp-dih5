// Temp Converter
// 1. Farenheit to Celsius
// 2. Celsius to Farenheit
// 3. Exit

const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

function showMenu() {
  console.log('Welcome to Temp Converter');
  console.log('1. Farenheit to Celsius');
  console.log('2. Celsius to Farenheit');
  console.log('3. Exit');
  rl.question('Enter your choice: ', function(choice) {
    handleChoice(choice);
  });
}

function handleChoice(choice) {
  switch (parseInt(choice)) {
    case 1:
      rl.question('Enter temperature in Farenheit: ', function(fahr) {
        const cel = ((parseFloat(fahr) - 32) * 5 / 9).toFixed(2);
        console.log(fahr + ' Farenheit is ' + cel + ' Celsius');
        askContinue();
      });
      break;
    case 2:
      rl.question('Enter temperature in Celsius: ', function(cel1) {
        const fahr1 = ((parseFloat(cel1) * 9 / 5) + 32).toFixed(2);
        console.log(cel1 + ' Celsius is ' + fahr1 + ' Farenheit');
        askContinue();
      });
      break;
    case 3:
      console.log('Thank You!!!');
      rl.close();
      break;
    default:
      console.log('Invalid Option');
      askContinue();
  }
}

function askContinue() {
  rl.question('Do you want to continue? (Y/N): ', function(option) {
    if (option.toLowerCase() === 'y') {
      showMenu();
    } else {
      console.log('Thank You!!!');
      rl.close();
    }
  });
}

showMenu();
