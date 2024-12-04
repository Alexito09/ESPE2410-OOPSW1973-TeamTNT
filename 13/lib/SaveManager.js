import fs from 'fs';
import soccerBall from './soccerBall.js';
import readline from 'readline';


export class SaveManager {
    static enterData() {
        const rl = readline.createInterface({
            input: process.stdin,
            output: process.stdout
        });

        return new Promise((resolve) => {
            rl.question('Enter the ball ID: ', (id) => {
                rl.question('Enter the brand of the ball: ', (brand) => {
                    rl.question('Enter the type of ball material: ', (material) => {
                        rl.question('Enter the size of the balloon: ', (size) => {
                            rl.close();
                            resolve(new soccerBall(id, brand, material, parseInt(size)));
                        });
                    });
                });
            });
        });
    }



    static readJSONFile() {
        try {
            const data = fs.readFileSync('soccerBall.json');
            return JSON.parse(data);
        } catch (err) {
            return [];
        }
    }


    static writeJSONFile(soccerBall) {
        const data = JSON.stringify(soccerBall, null, 2);
        fs.writeFileSync('soccerBall.json', data);
    }

    static deleteData() {
        const rl = readline.createInterface({
            input: process.stdin,
            output: process.stdout
        });

        return new Promise((resolve) => {
            rl.question('Enter the ID of the ball to delete: ', (id) => {
                rl.close();

                const soccerBalls = SaveManager.readJSONFile();
                const index = soccerBalls.findIndex((ball) => ball.id === id);

                if (index !== -1) {
                    soccerBalls.splice(index, 1); // Eliminar el balón de fútbol del array
                    SaveManager.writeJSONFile(soccerBalls); // Guardar el array actualizado en el archivo JSON
                    console.log(`Ball with ID ${id} has been deleted.`);
                } else {
                    console.log(`Ball with ID ${id} not found.`);
                }

                resolve();
            });
        });
    }


    static async showMenu() {
        const rl = readline.createInterface({
            input: process.stdin,
            output: process.stdout
        });

        const soccerBall = SaveManager.readJSONFile();

        while (true) {
            console.log('Select an option:');
            console.log('1. Enter a new ball');
            console.log('2. See balls');
            console.log('3. Exit');
            console.log('4. Delete a ball');
            
            const response = await new Promise((resolve) => {
                rl.question('Option: ', (option) => {
                    resolve(option);
                });
            });

            switch (response) {
                case '1':
                    const newsoccerBall = await SaveManager.enterData();
                    soccerBall.push(newsoccerBall);
                    SaveManager.writeJSONFile(soccerBall);
                    console.log('Data entered successfully.');
                    break;
                case '2':
                    console.log('Existing balls:');
                    soccerBall.forEach((soccerBall) => {
                        console.log(soccerBall.toString());
                    });
                    break;
                case '3':
                    rl.close();
                    return;
                    console.log('Invalid option. Try again.');
                    case '4':
                        await SaveManager.deleteData();
                        break;
                        console.log('Invalid option. Try again.');
                    default:
            }
        }
    }
}
