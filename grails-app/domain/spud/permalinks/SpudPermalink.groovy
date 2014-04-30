package spud.permalinks

class SpudPermalink {

	Integer siteId = 0
	String urlName
	String attachmentType
	Long attachmentId

	String destinationUrl

	Date dateCreated
	Date lastUpdated

  static constraints = {
  	attachmentType nullable: true
  	attachmentId nullable: true



  	// TODO: Create Index Compound on attachmentType, attachmentId
  }

	static mapping = {
		def cfg = it?.getBean('grailsApplication')?.config
        datasource(cfg?.spud?.core?.datasource ?: 'DEFAULT')
		table 'spud_permalinks'
		autoTimestamp true
		dateCreated column: 'created_at'
		lastUpdated column: 'updated_at'
		siteId index: 'idx_permalink_url'
  	urlName index: 'idx_permalink_url'

		// TODO: Add Compound index for attachmentType, attachmentId
	}
}
