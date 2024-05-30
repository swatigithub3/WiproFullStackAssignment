package com.day13;


public class Trie {
	class TrieNode{
		TrieNode[] children;
		boolean isEndOfWord;
		public TrieNode() {
			this.children = new TrieNode[26];
			this.isEndOfWord = false;
		}
	}
	private TrieNode root;
	public Trie() {
		this.root = new TrieNode();
	}
	public void insert(String word) {
		TrieNode current = root;
		for(char ch: word.toCharArray()) {
			int index = ch - 'a';
			if(current.children[index] == null) {
				current.children[index] = new TrieNode();
			}
			current = current.children[index];
		}
		current.isEndOfWord = true;
	}
	public boolean searchPrefix(String prefix) {
		TrieNode current = root;
		for(char ch: prefix.toCharArray()) {
			int index = ch - 'a';
			if(current.children[index] == null) {
				return false;
			}
			current = current.children[index];
		}
		return true;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("swati");
		trie.insert("ani");
		trie.insert("swadhin");
		System.out.println(trie.searchPrefix("a"));
		System.out.println(trie.searchPrefix("b"));

	}

}
