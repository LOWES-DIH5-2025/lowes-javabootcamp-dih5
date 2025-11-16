// Example for JS being Sync
function calc(a, b) {
  console.log('Inside calc');
  return new Promise((resolve) => {
    setTimeout(() => {
      console.log('Called after 2secs');
      resolve(a + b);
    }, 2000);
  });
}

async function execute() {
  const result = await calc(10, 20);
  console.log(result);
  console.log('Execution Completed');
}

execute();

console.log('Program Ended');