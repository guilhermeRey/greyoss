using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GuessingGame
{
    class Program : GuessingGameViewee
    {
        static void Main(string[] args)
        {
            Program program = new Program();

            GuessingGame game = new GuessingGame(program);
            game.Init(new Node(
                "lives in the water",
                new Node("monkey"),
                new Node("shark")));
        }

        public void Message(string msg)
        {
            Console.WriteLine(msg);
        }

        public string StringInput(string question)
        {
            Console.WriteLine(question);
            return Console.ReadLine();
        }

        public bool TrueOrFalse(string question)
        {
            Console.Write(question);
            Console.WriteLine(" [1 - true, 0 - false]");
            string input = Console.ReadLine();

            return input == "1";
        }


        public void Wait()
        {
            Console.ReadKey();
        }
    }
}
