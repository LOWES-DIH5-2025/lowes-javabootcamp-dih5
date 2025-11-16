// Welcome to Temp Converter
// 1. Farenheit to Celsius
// 2. Celsius to Farenheit
// 3. Exit

// Enter your choice: 1
// Enter temperature in Farenheit: 212
// 212 Farenheit is 100 Celsius

// Enter your choice: 2
// Enter temperature in Celsius: 100
// 100 Celsius is 212 Farenheit

// Do You want to continue? (Y/N): Y
// if yes, then show the menu again
// if no, then exit the program












do {
  console.log('Welcome to Temp Converter')
  console.log('1. Farenheit to Celsius')
  console.log('2. Celsius to Farenheit')
  console.log('3. Exit');
  let choice = parseInt(prompt('Enter your choice: '))
  console.log('choice is ' + choice)
  switch(choice) {
    case 1:
      let fahr = parseFloat(prompt('Enter temperature in Farenheit: '))
      let cel = (fahr - 32) * 5 / 9
      console.log(fahr + ' Farenheit is ' + cel.toFixed(2) + ' Celsius')
      break;
    case 2:
      let cel1 = parseFloat(prompt('Enter temperature in Celsius: '))
      let fahr1 = (cel1 * 9 / 5) + 32
      console.log(cel1 + ' Celsius is ' + fahr1.toFixed(2) + ' Farenheit')
      break;
    case 3:
      console.log('Thank You!!!')
      break;
    default:
      console.log('Invalid Option')
  }
  var option = prompt('Do you want to continue? (Y/N)')
  
} while(option === 'Y' || option === 'y')
  
// Do You want to continue? (Y/N): Y
// if yes, then show the menu again
// if no, then exit the program

