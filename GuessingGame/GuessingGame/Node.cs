using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GuessingGame
{
    public class Node
    {
        public Node Left { get; set; }
        public Node Right { get; set; }

        public Node Parent { get; set; }

        public string Data { get; set; }

        public Node() : this("")
        {

        }

        public Node(string data, Node left, Node right)
        {
            this.Data = data;
            this.Left = left;
            this.Right = right;

            this.Left.Parent = this;
            this.Right.Parent = this;
        }

        public Node(string data)
        {
            this.Data = data;
            this.Left = null;
            this.Right = null;
        }

        public Node(string data, Node parent) 
            : this(data)
        {
            this.Parent = parent;
        }
    }
}
