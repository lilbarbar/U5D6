import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import java.math.BigDecimal;
import java.math.BigInteger;


class Transaction {
    private String sender;
    private String recipient;
    private double amount;

    public Transaction(String sender, String recipient, double amount) {
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
    }

    // Getters
    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public double getAmount() {
        return amount;
    }
}

class Block {
    private String previousHash;
    private List<Transaction> transactions;
    private String hash;

    public Block(String previousHash) {
        this.previousHash = previousHash;
        this.transactions = new ArrayList<>();
        this.hash = calculateHash();
    }

    String calculateHash() {
        // Implement a hash function (e.g., SHA-256)
        return "hash";
    }

    // Add transaction to block
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}

class Blockchain {
    private List<Block> chain;
    private Map<String, Double> balances;

    public Blockchain() {
        chain = new ArrayList<>();
        chain.add(createGenesisBlock());
        balances = new HashMap<>();
    }

    private Block createGenesisBlock() {
        return new Block("0");
    }

    // Add block to blockchain
    public void addBlock(Block block) {
        chain.add(block);
    }

    // Process transactions
    public void processTransactions(Transaction transaction) {
        balances.put(transaction.getRecipient(), balances.getOrDefault(transaction.getRecipient(), 0.0) + transaction.getAmount());
        balances.put(transaction.getSender(), balances.getOrDefault(transaction.getSender(), 0.0) - transaction.getAmount());
    }

    // Get balance of a wallet
    public double getBalance(String walletAddress) {
        return balances.getOrDefault(walletAddress, 0.0);
    }
}

public class SimpleCryptocurrency {
    // Ethereum network URL
    private static final String ETHEREUM_NETWORK_URL = "https://mainnet.infura.io/v3/YOUR_INFURA_PROJECT_ID";
    // Sender's MetaMask address (your wallet address)
    private static final String SENDER_ADDRESS = "0xYourMetaMaskAddress";
    // Sender's MetaMask private key
    private static final String SENDER_PRIVATE_KEY = "YourPrivateKey";

    public static void main(String[] args) throws Exception {
        // Create blockchain
        Blockchain blockchain = new Blockchain();

        // Create transactions
        Transaction transaction1 = new Transaction("Alice", "Bob", 10.0);
        Transaction transaction2 = new Transaction("Bob", "Charlie", 5.0);

        // Create blocks
        Block block1 = new Block("0");
        block1.addTransaction(transaction1);

        Block block2 = new Block(block1.calculateHash());
        block2.addTransaction(transaction2);

        // Add blocks to blockchain
        blockchain.addBlock(block1);
        blockchain.addBlock(block2);

        // Process transactions
        blockchain.processTransactions(transaction1);
        blockchain.processTransactions(transaction2);

        // Check balances
        System.out.println("Bob's balance: " + blockchain.getBalance("Bob"));
        System.out.println("Charlie's balance: " + blockchain.getBalance("Charlie"));












        // Connect to Ethereum network

        
        // Web3j web3 = Web3j.build(new HttpService(ETHEREUM_NETWORK_URL));

        // // Initialize sender's transaction manager with MetaMask private key
        // ClientTransactionManager transactionManager = new ClientTransactionManager(web3, SENDER_ADDRESS);

        // // Transfer some Ethereum from sender's MetaMask wallet
        // Transfer.sendFunds(web3, transactionManager, "0xRecipientAddress",
        //         BigDecimal.valueOf(0.1), Convert.Unit.ETHER).sendAsync().get();

        // // Check sender's MetaMask wallet balance
        // BigInteger balance = web3.ethGetBalance(SENDER_ADDRESS, DefaultBlockParameterName.LATEST).send().getBalance();
        // System.out.println("Sender's MetaMask wallet balance: " + Convert.fromWei(balance.toString(), Convert.Unit.ETHER));


    }


    
}
