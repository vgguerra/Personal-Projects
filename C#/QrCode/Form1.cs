using System;
using System.Drawing;
using System.Windows.Forms;
using QRCoder;

namespace QrCode
{
    public partial class Form1 : Form
    {
        private Label lblSN;
        private Label lblModelo;
        private Label lblChave;
        private TextBox txtSN;
        private TextBox txtModelo;
        private TextBox txtChave;
        private Button btnGerarQRCode;
        private PictureBox pictureBox;

        public Form1()
        {
            InitializeComponent(); 
            InitializeControls();    
        }

        private void InitializeControls()
        {
            lblSN = new Label { Text = "Número de série:", Location = new Point(10, 10),  AutoSize = true };
            lblModelo = new Label { Text = "Modelo da câmera no padrão \"IMXB-C\":", Location = new Point(10, 40),  AutoSize = true };
            lblChave = new Label { Text = "Chave de acesso:", Location = new Point(10, 70), AutoSize = true };
            
            txtSN = new TextBox { Location = new Point(130, 10), Width = 200 };
            txtModelo = new TextBox { Location = new Point(237, 38), Width = 200 };
            txtChave = new TextBox { Location = new Point(130, 70), Width = 200 };
            
            btnGerarQRCode = new Button { Text = "Gerar QR Code", Location = new Point(10, 100), Width = 200 };
            btnGerarQRCode.Click += BtnGerarQRCode_Click;

            
            pictureBox = new PictureBox { Location = new Point(220, 150), Size = new Size(200, 200), SizeMode = PictureBoxSizeMode.StretchImage };
            
            this.Controls.Add(lblSN);
            this.Controls.Add(lblModelo);
            this.Controls.Add(lblChave);
            this.Controls.Add(txtSN);
            this.Controls.Add(txtModelo);
            this.Controls.Add(txtChave);
            this.Controls.Add(btnGerarQRCode);
            this.Controls.Add(pictureBox);
        }
        

        private void BtnGerarQRCode_Click(object sender, EventArgs e)
        {
            string SN = txtSN.Text;
            string modelo = txtModelo.Text;
            string chave = txtChave.Text;

            string dados = "{SN:" + SN + ",DT:" + modelo + ",SC:" + chave + "}";

            QRCodeGenerator qrGenerator = new QRCodeGenerator();
            QRCodeData qrCodeData = qrGenerator.CreateQrCode(dados, QRCodeGenerator.ECCLevel.Q);
            QRCode qrCode = new QRCode(qrCodeData);
            Bitmap qrCodeImage = qrCode.GetGraphic(20);

            pictureBox.Image = qrCodeImage;
        }
    }
}
