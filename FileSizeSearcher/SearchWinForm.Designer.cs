namespace FileSizeSearcher
{
    partial class SearchWinForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label2 = new System.Windows.Forms.Label();
            this.txtMinSize = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.progressBar1 = new System.Windows.Forms.ProgressBar();
            this.lblConsole = new System.Windows.Forms.Label();
            this.btnSelectStartFolder = new System.Windows.Forms.Button();
            this.btnStartSearch = new System.Windows.Forms.Button();
            this.txtStartFolder = new System.Windows.Forms.TextBox();
            this.boxSettings = new System.Windows.Forms.GroupBox();
            this.gridResults = new System.Windows.Forms.DataGridView();
            this.folderBrowserDialog1 = new System.Windows.Forms.FolderBrowserDialog();
            this.label3 = new System.Windows.Forms.Label();
            this.searchType = new System.Windows.Forms.ComboBox();
            this.btnStop = new System.Windows.Forms.Button();
            this.boxSettings.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.gridResults)).BeginInit();
            this.SuspendLayout();
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(12, 48);
            this.label2.Margin = new System.Windows.Forms.Padding(6, 0, 6, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(130, 25);
            this.label2.TabIndex = 20;
            this.label2.Text = "Start Folder:";
            // 
            // txtMinSize
            // 
            this.txtMinSize.Location = new System.Drawing.Point(258, 92);
            this.txtMinSize.Margin = new System.Windows.Forms.Padding(6, 6, 6, 6);
            this.txtMinSize.Name = "txtMinSize";
            this.txtMinSize.Size = new System.Drawing.Size(247, 31);
            this.txtMinSize.TabIndex = 19;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 98);
            this.label1.Margin = new System.Windows.Forms.Padding(6, 0, 6, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(236, 25);
            this.label1.TabIndex = 18;
            this.label1.Text = "Minimum Size (Mbytes)";
            // 
            // progressBar1
            // 
            this.progressBar1.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.progressBar1.Location = new System.Drawing.Point(24, 246);
            this.progressBar1.Margin = new System.Windows.Forms.Padding(6, 6, 6, 6);
            this.progressBar1.Name = "progressBar1";
            this.progressBar1.Size = new System.Drawing.Size(809, 44);
            this.progressBar1.TabIndex = 17;
            // 
            // lblConsole
            // 
            this.lblConsole.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.lblConsole.AutoSize = true;
            this.lblConsole.Location = new System.Drawing.Point(24, 204);
            this.lblConsole.Margin = new System.Windows.Forms.Padding(6, 0, 6, 0);
            this.lblConsole.Name = "lblConsole";
            this.lblConsole.Size = new System.Drawing.Size(91, 25);
            this.lblConsole.TabIndex = 16;
            this.lblConsole.Text = "Console";
            // 
            // btnSelectStartFolder
            // 
            this.btnSelectStartFolder.Location = new System.Drawing.Point(636, 38);
            this.btnSelectStartFolder.Margin = new System.Windows.Forms.Padding(6, 6, 6, 6);
            this.btnSelectStartFolder.Name = "btnSelectStartFolder";
            this.btnSelectStartFolder.Size = new System.Drawing.Size(138, 38);
            this.btnSelectStartFolder.TabIndex = 15;
            this.btnSelectStartFolder.Text = "Browse...";
            this.btnSelectStartFolder.UseVisualStyleBackColor = true;
            this.btnSelectStartFolder.Click += new System.EventHandler(this.btnSelectStartFolder_Click);
            // 
            // btnStartSearch
            // 
            this.btnStartSearch.BackColor = System.Drawing.Color.Green;
            this.btnStartSearch.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.btnStartSearch.Location = new System.Drawing.Point(845, 30);
            this.btnStartSearch.Margin = new System.Windows.Forms.Padding(6, 6, 6, 6);
            this.btnStartSearch.Name = "btnStartSearch";
            this.btnStartSearch.Size = new System.Drawing.Size(131, 69);
            this.btnStartSearch.TabIndex = 14;
            this.btnStartSearch.Text = "Begin";
            this.btnStartSearch.UseVisualStyleBackColor = false;
            this.btnStartSearch.Click += new System.EventHandler(this.btnStartSearch_Click);
            // 
            // txtStartFolder
            // 
            this.txtStartFolder.Location = new System.Drawing.Point(152, 42);
            this.txtStartFolder.Margin = new System.Windows.Forms.Padding(6, 6, 6, 6);
            this.txtStartFolder.Name = "txtStartFolder";
            this.txtStartFolder.Size = new System.Drawing.Size(472, 31);
            this.txtStartFolder.TabIndex = 13;
            // 
            // boxSettings
            // 
            this.boxSettings.Controls.Add(this.searchType);
            this.boxSettings.Controls.Add(this.label3);
            this.boxSettings.Controls.Add(this.label2);
            this.boxSettings.Controls.Add(this.txtStartFolder);
            this.boxSettings.Controls.Add(this.txtMinSize);
            this.boxSettings.Controls.Add(this.label1);
            this.boxSettings.Controls.Add(this.btnSelectStartFolder);
            this.boxSettings.Location = new System.Drawing.Point(24, 23);
            this.boxSettings.Margin = new System.Windows.Forms.Padding(6, 6, 6, 6);
            this.boxSettings.Name = "boxSettings";
            this.boxSettings.Padding = new System.Windows.Forms.Padding(6, 6, 6, 6);
            this.boxSettings.Size = new System.Drawing.Size(809, 152);
            this.boxSettings.TabIndex = 21;
            this.boxSettings.TabStop = false;
            this.boxSettings.Text = "Settings";
            // 
            // gridResults
            // 
            this.gridResults.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.gridResults.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.gridResults.Location = new System.Drawing.Point(24, 302);
            this.gridResults.Margin = new System.Windows.Forms.Padding(6, 6, 6, 6);
            this.gridResults.Name = "gridResults";
            this.gridResults.Size = new System.Drawing.Size(1596, 498);
            this.gridResults.TabIndex = 22;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(514, 95);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(133, 25);
            this.label3.TabIndex = 21;
            this.label3.Text = "Search type:";
            // 
            // searchType
            // 
            this.searchType.FormattingEnabled = true;
            this.searchType.Items.AddRange(new object[] {
            "Folders",
            "Files"});
            this.searchType.Location = new System.Drawing.Point(653, 95);
            this.searchType.Name = "searchType";
            this.searchType.Size = new System.Drawing.Size(121, 33);
            this.searchType.TabIndex = 22;
            // 
            // btnStop
            // 
            this.btnStop.BackColor = System.Drawing.Color.Crimson;
            this.btnStop.Enabled = false;
            this.btnStop.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.btnStop.Location = new System.Drawing.Point(845, 111);
            this.btnStop.Margin = new System.Windows.Forms.Padding(6);
            this.btnStop.Name = "btnStop";
            this.btnStop.Size = new System.Drawing.Size(128, 69);
            this.btnStop.TabIndex = 23;
            this.btnStop.Text = "Stop";
            this.btnStop.UseVisualStyleBackColor = false;
            this.btnStop.Click += new System.EventHandler(this.btnStop_Click);
            // 
            // SearchWinForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(12F, 25F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1638, 823);
            this.Controls.Add(this.btnStop);
            this.Controls.Add(this.gridResults);
            this.Controls.Add(this.boxSettings);
            this.Controls.Add(this.progressBar1);
            this.Controls.Add(this.lblConsole);
            this.Controls.Add(this.btnStartSearch);
            this.Margin = new System.Windows.Forms.Padding(6, 6, 6, 6);
            this.Name = "SearchWinForm";
            this.Text = "SearchWinForm";
            this.boxSettings.ResumeLayout(false);
            this.boxSettings.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.gridResults)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox txtMinSize;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ProgressBar progressBar1;
        private System.Windows.Forms.Label lblConsole;
        private System.Windows.Forms.Button btnSelectStartFolder;
        private System.Windows.Forms.Button btnStartSearch;
        private System.Windows.Forms.TextBox txtStartFolder;
        private System.Windows.Forms.GroupBox boxSettings;
        private System.Windows.Forms.DataGridView gridResults;
        private System.Windows.Forms.FolderBrowserDialog folderBrowserDialog1;
        private System.Windows.Forms.ComboBox searchType;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button btnStop;
    }
}