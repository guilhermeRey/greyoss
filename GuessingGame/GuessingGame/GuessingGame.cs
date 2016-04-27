using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GuessingGame
{
    public class GuessingGame
    {
        private Node _root;
        private Node _current;

        private int count;

        private GuessingGameViewee _viewee;

        public GuessingGame(GuessingGameViewee viewee)
        {
            this._viewee = viewee;
            this.count = 0;
        }

        public void Init(Node root)
        {
            this._root = root;
            this._current = _root;
            Guess();
        }

        private void Guess()
        {
            if (HasQuestion)
            {
                _current = _viewee.TrueOrFalse("Does the animal that you thougth about " + _current.Data + "?") ? 
                    _current.Right : _current.Left;
                Guess();
            }
            else
            {
                if (!_viewee.TrueOrFalse("Is the animal that you thought about a " + _current.Data + "?"))
                {
                    MissedGuess();
                    _viewee.Message("I will try again!");
                }
                else
                    _viewee.Message("I win! ^.^");
                
                _current = _root;
                Guess();
            }
        }

        private void MissedGuess()
        {
            string guess = this._viewee.StringInput("What was the animal that you thought about?");
            string guessUnique = this._viewee.StringInput(String.Format("A {0} ______ but a {1} does not.", guess, _current.Data));

            Node guessNode = new Node(guess);
            Node newGuessQuestion = new Node(guessUnique);

            newGuessQuestion.Parent = _current.Parent;

            if (_current.Parent.Right.Data.Equals(_current.Data))
                _current.Parent.Right = newGuessQuestion;
            else
                _current.Parent.Left = newGuessQuestion;

            _current.Parent = newGuessQuestion;

            guessNode.Parent = newGuessQuestion;
            newGuessQuestion.Right = guessNode;
            newGuessQuestion.Left = _current;

            count++;
        }

        private bool HasQuestion
        {
            get
            {
                return this._current.Left != null && this._current.Right != null;
            }
        }
    }
}
