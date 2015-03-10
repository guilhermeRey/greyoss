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
            this.boxSettings.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.gridResults)).BeginInit();
            this.SuspendLayout();
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(6, 25);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(64, 13);
            this.label2.TabIndex = 20;
            this.label2.Text = "Start Folder:";
            // 
            // txtMinSize
            // 
            this.txtMinSize.Location = new System.Drawing.Point(129, 48);
            this.txtMinSize.Name = "txtMinSize";
            this.txtMinSize.Size = new System.Drawing.Size(239, 20);
            this.txtMinSize.TabIndex = 19;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(6, 51);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(117, 13);
            this.label1.TabIndex = 18;
            this.label1.Text = "Minimum File Size (Mb):";
            // 
            // progressBar1
            // 
            this.progressBar1.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.progressBar1.Location = new System.Drawing.Point(12, 128);
            this.progressBar1.Name = "progressBar1";
            this.progressBar1.Size = new System.Drawing.Size(798, 23);
            this.progressBar1.TabIndex = 17;
            // 
            // lblConsole
            // 
            this.lblConsole.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.lblConsole.AutoSize = true;
            this.lblConsole.Location = new System.Drawing.Point(12, 106);
            this.lblConsole.Name = "lblConsole";
            this.lblConsole.Size = new System.Drawing.Size(45, 13);
            this.lblConsole.TabIndex = 16;
            this.lblConsole.Text = "Console";
            // 
            // btnSelectStartFolder
            // 
            this.btnSelectStartFolder.Location = new System.Drawing.Point(374, 22);
            this.btnSelectStartFolder.Name = "btnSelectStartFolder";
            this.btnSelectStartFolder.Size = new System.Drawing.Size(69, 20);
            this.btnSelectStartFolder.TabIndex = 15;
            this.btnSelectStartFolder.Text = "Browse...";
            this.btnSelectStartFolder.UseVisualStyleBackColor = true;
            this.btnSelectStartFolder.Click += new System.EventHandler(this.btnSelectStartFolder_Click);
            // 
            // btnStartSearch
            // 
            this.btnStartSearch.BackColor = System.Drawing.Color.Green;
            this.btnStartSearch.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.btnStartSearch.Location = new System.Drawing.Point(471, 18);
            this.btnStartSearch.Name = "btnStartSearch";
            this.btnStartSearch.Size = new System.Drawing.Size(124, 36);
            this.btnStartSearch.TabIndex = 14;
            this.btnStartSearch.Text = "Begin Search";
            this.btnStartSearch.UseVisualStyleBackColor = false;
            this.btnStartSearch.Click += new System.EventHandler(this.btnStartSearch_Click);
            // 
            // txtStartFolder
            // 
            this.txtStartFolder.Location = new System.Drawing.Point(76, 22);
            this.txtStartFolder.Name = "txtStartFolder";
            this.txtStartFolder.Size = new System.Drawing.Size(292, 20);
            this.txtStartFolder.TabIndex = 13;
            // 
            // boxSettings
            // 
            this.boxSettings.Controls.Add(this.label2);
            this.boxSettings.Controls.Add(this.txtStartFolder);
            this.boxSettings.Controls.Add(this.txtMinSize);
            this.boxSettings.Controls.Add(this.label1);
            this.boxSettings.Controls.Add(this.btnSelectStartFolder);
            this.boxSettings.Location = new System.Drawing.Point(12, 12);
            this.boxSettings.Name = "boxSettings";
            this.boxSettings.Size = new System.Drawing.Size(453, 79);
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
            this.gridResults.Location = new System.Drawing.Point(12, 157);
            this.gridResults.Name = "gridResults";
            this.gridResults.Size = new System.Drawing.Size(798, 259);
            this.gridResults.TabIndex = 22;
            // 
            // SearchWinForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(819, 428);
            this.Controls.Add(this.gridResults);
            this.Controls.Add(this.boxSettings);
            this.Controls.Add(this.progressBar1);
            this.Controls.Add(this.lblConsole);
            this.Controls.Add(this.btnStartSearch);
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
    }
}