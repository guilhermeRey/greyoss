namespace FileSizeSearcher
{
    partial class SearchForm
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
            this.splitContainer1 = new System.Windows.Forms.SplitContainer();
            this.label2 = new System.Windows.Forms.Label();
            this.txtMinSize = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.progressBar1 = new System.Windows.Forms.ProgressBar();
            this.lblConsole = new System.Windows.Forms.Label();
            this.btnSelectStartFolder = new System.Windows.Forms.Button();
            this.btnStartLook = new System.Windows.Forms.Button();
            this.txtStartFolder = new System.Windows.Forms.TextBox();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.gridResults = new System.Windows.Forms.DataGridView();
            this.folderBrowserDialog1 = new System.Windows.Forms.FolderBrowserDialog();
            ((System.ComponentModel.ISupportInitialize)(this.splitContainer1)).BeginInit();
            this.splitContainer1.Panel1.SuspendLayout();
            this.splitContainer1.Panel2.SuspendLayout();
            this.splitContainer1.SuspendLayout();
            this.groupBox1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.gridResults)).BeginInit();
            this.SuspendLayout();
            // 
            // splitContainer1
            // 
            this.splitContainer1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.splitContainer1.Location = new System.Drawing.Point(0, 0);
            this.splitContainer1.Name = "splitContainer1";
            this.splitContainer1.Orientation = System.Windows.Forms.Orientation.Horizontal;
            // 
            // splitContainer1.Panel1
            // 
            this.splitContainer1.Panel1.Controls.Add(this.label2);
            this.splitContainer1.Panel1.Controls.Add(this.txtMinSize);
            this.splitContainer1.Panel1.Controls.Add(this.label1);
            this.splitContainer1.Panel1.Controls.Add(this.progressBar1);
            this.splitContainer1.Panel1.Controls.Add(this.lblConsole);
            this.splitContainer1.Panel1.Controls.Add(this.btnSelectStartFolder);
            this.splitContainer1.Panel1.Controls.Add(this.btnStartLook);
            this.splitContainer1.Panel1.Controls.Add(this.txtStartFolder);
            // 
            // splitContainer1.Panel2
            // 
            this.splitContainer1.Panel2.Controls.Add(this.groupBox1);
            this.splitContainer1.Size = new System.Drawing.Size(997, 401);
            this.splitContainer1.SplitterDistance = 135;
            this.splitContainer1.TabIndex = 7;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(12, 15);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(64, 13);
            this.label2.TabIndex = 12;
            this.label2.Text = "Start Folder:";
            // 
            // txtMinSize
            // 
            this.txtMinSize.Location = new System.Drawing.Point(276, 38);
            this.txtMinSize.Name = "txtMinSize";
            this.txtMinSize.Size = new System.Drawing.Size(78, 20);
            this.txtMinSize.TabIndex = 11;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(153, 41);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(117, 13);
            this.label1.TabIndex = 10;
            this.label1.Text = "Minimum File Size (Mb):";
            // 
            // progressBar1
            // 
            this.progressBar1.Location = new System.Drawing.Point(12, 94);
            this.progressBar1.Name = "progressBar1";
            this.progressBar1.Size = new System.Drawing.Size(708, 23);
            this.progressBar1.TabIndex = 9;
            // 
            // lblConsole
            // 
            this.lblConsole.AutoSize = true;
            this.lblConsole.Location = new System.Drawing.Point(12, 78);
            this.lblConsole.Name = "lblConsole";
            this.lblConsole.Size = new System.Drawing.Size(35, 13);
            this.lblConsole.TabIndex = 8;
            this.lblConsole.Text = "label2";
            // 
            // btnSelectStartFolder
            // 
            this.btnSelectStartFolder.Location = new System.Drawing.Point(360, 10);
            this.btnSelectStartFolder.Name = "btnSelectStartFolder";
            this.btnSelectStartFolder.Size = new System.Drawing.Size(124, 23);
            this.btnSelectStartFolder.TabIndex = 7;
            this.btnSelectStartFolder.Text = "Browse...";
            this.btnSelectStartFolder.UseVisualStyleBackColor = true;
            this.btnSelectStartFolder.Click += new System.EventHandler(this.btnSelectStartFolder_Click_1);
            // 
            // btnStartLook
            // 
            this.btnStartLook.BackColor = System.Drawing.Color.Green;
            this.btnStartLook.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.btnStartLook.Location = new System.Drawing.Point(360, 36);
            this.btnStartLook.Name = "btnStartLook";
            this.btnStartLook.Size = new System.Drawing.Size(124, 23);
            this.btnStartLook.TabIndex = 6;
            this.btnStartLook.Text = "Begin Search";
            this.btnStartLook.UseVisualStyleBackColor = false;
            this.btnStartLook.Click += new System.EventHandler(this.btnStartLook_Click);
            // 
            // txtStartFolder
            // 
            this.txtStartFolder.Location = new System.Drawing.Point(82, 12);
            this.txtStartFolder.Name = "txtStartFolder";
            this.txtStartFolder.Size = new System.Drawing.Size(272, 20);
            this.txtStartFolder.TabIndex = 5;
            // 
            // groupBox1
            // 
            this.groupBox1.AutoSize = true;
            this.groupBox1.Controls.Add(this.gridResults);
            this.groupBox1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.groupBox1.Location = new System.Drawing.Point(0, 0);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(997, 262);
            this.groupBox1.TabIndex = 5;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Results";
            // 
            // gridResults
            // 
            this.gridResults.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.gridResults.Dock = System.Windows.Forms.DockStyle.Fill;
            this.gridResults.Location = new System.Drawing.Point(3, 16);
            this.gridResults.Name = "gridResults";
            this.gridResults.Size = new System.Drawing.Size(991, 243);
            this.gridResults.TabIndex = 0;
            // 
            // SearchForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(997, 401);
            this.Controls.Add(this.splitContainer1);
            this.Name = "SearchForm";
            this.Text = "File Size Searcher";
            this.splitContainer1.Panel1.ResumeLayout(false);
            this.splitContainer1.Panel1.PerformLayout();
            this.splitContainer1.Panel2.ResumeLayout(false);
            this.splitContainer1.Panel2.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.splitContainer1)).EndInit();
            this.splitContainer1.ResumeLayout(false);
            this.groupBox1.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.gridResults)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.SplitContainer splitContainer1;
        private System.Windows.Forms.FolderBrowserDialog folderBrowserDialog1;
        private System.Windows.Forms.ProgressBar progressBar1;
        private System.Windows.Forms.Label lblConsole;
        private System.Windows.Forms.Button btnSelectStartFolder;
        private System.Windows.Forms.Button btnStartLook;
        private System.Windows.Forms.TextBox txtStartFolder;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.DataGridView gridResults;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txtMinSize;
        private System.Windows.Forms.Label label2;
    }
}

