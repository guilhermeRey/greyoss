using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GuessingGame
{
    public interface GuessingGameViewee
    {
        void Message(string msg);
        string StringInput(string question);
        bool TrueOrFalse(string question);
        void Wait();
    }
}