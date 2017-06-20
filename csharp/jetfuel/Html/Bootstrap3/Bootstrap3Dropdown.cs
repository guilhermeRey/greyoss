﻿using System;
using System.Collections.Generic;
using System.Text;

namespace EixoX.Html.Controls
{
    public class Bootstrap3Dropdown : Bootstrap3Control
    {
        protected override HtmlNode CreateInput(UI.UIControlState state)
        {
            HtmlComposite select = new HtmlComposite("select",
                new HtmlAttribute("id", state.Name),
                new HtmlAttribute("name", state.Name),
                new HtmlAttribute("class", "form-control"));

            if (state.Options != null)
                foreach (KeyValuePair<object, object> item in state.Options)
                {
                    HtmlSimple option = new HtmlSimple("option", item.Value);
                    option.Attributes.AddLast(new HtmlAttribute("value", item.Key));

                    if (state.Value != null && item.Key.ToString().Equals(state.Value.ToString()))
                        option.Attributes.AddLast("selected", "selected");

                    select.Children.AddLast(option);
                }

            return select;
        }
    }
}
